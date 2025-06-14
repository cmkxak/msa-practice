package me.project.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentRequest {

    private String memberId;

    private String cpId;

    private Long payAmount;

    private PaymentType paymentType;

}
