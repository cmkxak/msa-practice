package me.project.bankingservice.application.port.out;

import me.project.bankingservice.adapter.out.persistence.RegistBankAccountEntity;
import org.springframework.stereotype.Component;

@Component
public interface RegistBankAccountPort {

    RegistBankAccountEntity createRegistBankAccountEntity(
            String memberId,
            String bankName,
            String bankAccountNumber,
            boolean linkedStatus
    );
}
