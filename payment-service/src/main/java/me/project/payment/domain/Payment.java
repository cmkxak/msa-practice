package me.project.payment.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Payment {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long payAmount;

    private String payAt;

    private String registAt;

    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    private String memberId;

    private String cpId;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public static Payment createPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .payAmount(paymentRequest.getPayAmount())
                .registAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .payStatus(PayStatus.PAY_REGIST)
                .paymentType(paymentRequest.getPaymentType())
                .memberId(paymentRequest.getMemberId())
                .cpId(paymentRequest.getCpId())
                .build();
    }

    public void updatePaySuccess() {
        this.payStatus = PayStatus.PAY_SUCCESS;
        this.payAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public void updateStatus(PayStatus payStatus) {

    }
}
