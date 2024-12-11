package me.project.bankingservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import me.project.bankingservice.application.port.out.RegistBankAccountPort;

//@PersistenceAdapter
@RequiredArgsConstructor
public class RegistBankAccountPersistenceAdapter implements RegistBankAccountPort {

    private final RegistBankAccountRepository registBankAccountRepository;

    @Override
    public RegistBankAccountEntity createRegistBankAccountEntity(
            String memberId,
            String bankName,
            String bankAccountNumber,
            boolean linkedStatus
    ) {
        return registBankAccountRepository.save(
                new RegistBankAccountEntity(
                        memberId,
                        bankName,
                        bankAccountNumber,
                        linkedStatus
                )
        );
    }
}
