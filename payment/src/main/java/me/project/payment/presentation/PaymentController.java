package me.project.payment.presentation;

import lombok.RequiredArgsConstructor;
import me.project.payment.application.PaymentService;
import me.project.payment.domain.PaymentRequest;
import me.project.payment.domain.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentResponse> pay(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.pay(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }


}
