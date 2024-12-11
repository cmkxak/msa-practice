package me.project.payment.application;

import lombok.RequiredArgsConstructor;
import me.project.payment.common.MemberLimitResponse;
import me.project.payment.common.MemberStatusResponse;
import me.project.payment.domain.PaymentRequest;
import me.project.payment.domain.PaymentResponse;
import me.project.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final MemberServiceClient memberServiceClient;
    private final PaymentRepository paymentRepository;
    private final MemberServiceClient memberServiceClient;

    @Transactional
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        validateMemberstatus(paymentRequest.getMemberId());
        validateCpStatus(paymentRequest.getCpId());
        validateMemberLimit(paymentRequest);
        requestPay(paymentRequest);
        return PaymentResponse.of();
    }

    /**
     *
     */
    private void requestPay(PaymentRequest paymentRequest) {

    }

    /**
     * 회원의 한도를 검증한다.
     */
    private void validateMemberLimit(PaymentRequest paymentRequest) {

    }

    /**
     * 가맹점 상태를 검증한다.
     */
    private void validateCpStatus(String cpId) {

    }

    /**
     * 회원의 상태를 검증한다.
     */
    private void validateMemberstatus(String memberId) {
        MemberStatusResponse memberStatusResponse = memberServiceClient
                .getMemberStatus(memberId);

        if ("ACTIVE".equals(memberStatusResponse.getMemberStatus()))
            throw new CmpayExce
    }
}
