package me.project.payment.domain;

import jakarta.persistence.*;
import lombok.*;

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

    private String payStatus;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

}
