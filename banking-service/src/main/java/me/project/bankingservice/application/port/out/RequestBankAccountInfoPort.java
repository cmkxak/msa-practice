package me.project.bankingservice.application.port.out;

import me.project.bankingservice.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfoPort(
            String bankName,
            String bankAccountNumber
    );


}
