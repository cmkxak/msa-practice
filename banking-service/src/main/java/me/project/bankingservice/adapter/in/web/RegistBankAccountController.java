package me.project.bankingservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import me.project.bankingservice.application.port.in.RegistBankAccountCommand;
import me.project.bankingservice.application.port.in.RegistBankAccountUseCase;
import me.project.bankingservice.domain.RegistBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@WebAdpater
@RequestMapping("/api/v1/banking")
@RequiredArgsConstructor
@RestController
public class RegistBankAccountController {

    private final RegistBankAccountUseCase registBankAccountUseCase;

    @PostMapping
    public RegistBankAccount registBankAccount(@RequestBody RegistBankAccountRequest request) {
        return registBankAccountUseCase.registBankAccount(
                new RegistBankAccountCommand(
                        request.getMemberId(),
                        request.getBankName(),
                        request.getBankAccountNumber(),
                        request.isValid()
                )
        );
    }

}
