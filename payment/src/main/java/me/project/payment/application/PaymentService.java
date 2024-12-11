package me.project.payment.application;

import lombok.RequiredArgsConstructor;
import me.project.common.Exception.CmPayExcetion;
import me.project.payment.common.CpStatusResponse;
import me.project.payment.common.MemberLimitResponse;
import me.project.payment.common.MemberStatusResponse;
import me.project.payment.common.MoneyBalanceResponse;
import me.project.payment.domain.PayStatus;
import me.project.payment.domain.Payment;
import me.project.payment.domain.PaymentRequest;
import me.project.payment.domain.PaymentResponse;
import me.project.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static me.project.common.Exception.CmPayExcetion.ErrorCode.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final MemberServiceClient memberServiceClient;
    private final CpServiceClient cpServiceClient;
    private final PaymentRepository paymentRepository;
    private final MoneyServiceClient moneyServiceClient;

    @Transactional
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        /* 1. 회원 검증 */
        validateMemberstatus(paymentRequest.getMemberId());

        /* 2. 가맹점 검증 */
        validateCpStatus(paymentRequest.getCpId());

        /* 3. 잔액 검증 */
        validateMemberBalance(paymentRequest);

        /* 4. 한도 검증 */
        validateMemberLimit(paymentRequest);

        /* 5. 결제 원장 생성 (결제 상태 : REGISTED, 트랜잭션 상태 저장) */
        Payment createdPayment = registPayment(paymentRequest);

        /* 6. 결제  (결제 상태 : SUCCESS or FAIL)*/
        requestPay(createdPayment);

        /* 7. 응답값 반환 */
        return PaymentResponse.of();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requestPay(Payment payment) {
        //money 서비스에 유저의 머니 차감 요청

        //성공 응답 수신 시, 결제 성공 처리

        //실패 응답 수신 시, 보상 충전 + 익셉션 throw
    }

    /**
     * 회원의 잔액을 검증한다.
     */
    private void validateMemberBalance(PaymentRequest paymentRequest) {
        MoneyBalanceResponse moneyBalanceResponse = moneyServiceClient
                .getMoneyBalanceResponse(paymentRequest.getMemberId());

        if (moneyBalanceResponse.getBalance() <= 0)
            throw new CmPayExcetion(INSUFFICIENT_BALANCE.getMessage(), INSUFFICIENT_BALANCE);

        if (paymentRequest.getPayAmount() > moneyBalanceResponse.getBalance())
            throw new CmPayExcetion(INVALID_PAY_AMOUNT.getMessage(), INVALID_PAY_AMOUNT);
    }

    /**
     * 결제 원장을 등록한다. (트랜잭션 상태 저장 )
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment registPayment(PaymentRequest paymentRequest) {
        Payment payment = Payment.createPayment(paymentRequest);
        return paymentRepository.save(payment);
    }

    /**
     * 회원의 한도를 검증한다.
     */
    private void validateMemberLimit(PaymentRequest paymentRequest) {
        MemberLimitResponse memberLimitResponse = memberServiceClient
                .getMemberLimit(paymentRequest.getMemberId());

        if (memberLimitResponse.getDayLimitAmount() == 0 ||
                paymentRequest.getPayAmount() < memberLimitResponse.getDayLimitAmount()
        )
            throw new CmPayExcetion(DAY_LIMIT_EXCEEDED.getMessage(), DAY_LIMIT_EXCEEDED);

        if (memberLimitResponse.getMonthLimitAmount() == 0 ||
                paymentRequest.getPayAmount() < memberLimitResponse.getMonthLimitAmount()
        )
            throw new CmPayExcetion(MONTH_LIMIT_EXCEEDED.getMessage(), MONTH_LIMIT_EXCEEDED);

    }

    /**
     * 가맹점 상태를 검증한다.
     */
    private void validateCpStatus(String cpId) {
        CpStatusResponse cpStatus = cpServiceClient.getCpStatus(cpId);

        if (!"ACTIVE".equals(cpStatus.getCpStatus()))
            throw new CmPayExcetion(INVALID_CP.getMessage(), INVALID_CP);
    }

    /**
     * 회원의 상태를 검증한다.
     * 내부의 비즈니스 로직에서 외부로 나가야한다.
     */
    private void validateMemberstatus(String memberId) {
        MemberStatusResponse memberStatusResponse = memberServiceClient
                .getMemberStatus(memberId);

        if (!"ACTIVE".equals(memberStatusResponse.getMemberStatus()))
            throw new CmPayExcetion(INVALID_MEMBER.getMessage(), INVALID_MEMBER);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PaymentResponse updatePaymentSuccess(Payment payment) {
        Payment managedPayment = findPaymentById(payment.getId());
        managedPayment.updateStatus(PayStatus.PAY_SUCCESS);
        return PaymentResponse.of();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void compensatePayment(Payment payment) {
        Payment managedPayment = findPaymentById(payment.getId());

        requestCompensateCharge(managedPayment);
    }

    private Payment findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new CmPayExcetion(NOT_FOUND_PAY.getMessage(), NOT_FOUND_PAY));
    }

    private void requestCompensateCharge(Payment managedPayment) {
        managedPayment.updateStatus(PayStatus.PAY_NET_CANCEL_REQEUST);

        //todo : 머니 서비스에 보상 충전 요청

        // todo : 성공 응답 시
        managedPayment.updateStatus(PayStatus.PAY_NET_CANCEL);

        // todo : 실패 응답 시 - throw Exception (망취소 실패)
    }
}
