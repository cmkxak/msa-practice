package me.project.bankingservice.adapter.out.persistence;

import me.project.bankingservice.domain.RegistBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegistBankAccountMapper {

    public RegistBankAccount mapToDomain(RegistBankAccountEntity registBankAccountEntity) {
        return new RegistBankAccount(
                registBankAccountEntity.getRegistBankAccountId(),
                registBankAccountEntity.getMemberId(),
                registBankAccountEntity.getBankName(),
                registBankAccountEntity.getBankAccountNumber(),
                registBankAccountEntity.isLinkedStatus()
        );
    }
}
