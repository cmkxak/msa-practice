package me.project.bankingservice.application.port.in;

import me.project.bankingservice.domain.RegistBankAccount;
import org.springframework.stereotype.Component;

@Component
public interface RegistBankAccountUseCase {

    RegistBankAccount registBankAccount(RegistBankAccountCommand command);
}
