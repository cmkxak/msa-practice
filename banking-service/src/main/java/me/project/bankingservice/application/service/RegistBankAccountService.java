package me.project.bankingservice.application.service;

import lombok.RequiredArgsConstructor;
import me.project.bankingservice.adapter.out.persistence.RegistBankAccountEntity;
import me.project.bankingservice.adapter.out.persistence.RegistBankAccountMapper;
import me.project.bankingservice.application.port.in.RegistBankAccountCommand;
import me.project.bankingservice.application.port.in.RegistBankAccountUseCase;
import me.project.bankingservice.application.port.out.RegistBankAccountPort;
import me.project.bankingservice.application.port.out.RequestBankAccountInfoPort;
import me.project.bankingservice.domain.BankAccount;
import me.project.bankingservice.domain.RegistBankAccount;
import me.project.common.Exception.CmPayExcetion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static me.project.common.Exception.CmPayExcetion.ErrorCode.INVALID_BANK_ACCOUNT;

//@Usecase
@Transactional
@RequiredArgsConstructor
@Service
public class RegistBankAccountService implements RegistBankAccountUseCase {

    private final RegistBankAccountPort registBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    private final RegistBankAccountMapper registBankAccountMapper;

    @Override
    public RegistBankAccount registBankAccount(RegistBankAccountCommand command) {
        //todo : 1. 회원 상태 조회
        BankAccount bankAccount = getBankAccountInfoFromExtenral(command);
        validateBankAccountStatus(bankAccount);
        RegistBankAccountEntity registBankAccountEntity = getRegistBankAccountEntity(command);
        return registBankAccountMapper.mapToDomain(registBankAccountEntity);
    }

    private BankAccount getBankAccountInfoFromExtenral(RegistBankAccountCommand command) {
        return requestBankAccountInfoPort.getBankAccountInfoPort(
                command.getBankName(), command.getBankAccountNumber()
        );
    }

    private void validateBankAccountStatus(BankAccount account) {
        if (!account.isAccountStatusValid())
            throw new CmPayExcetion(INVALID_BANK_ACCOUNT.getMessage(),
                    INVALID_BANK_ACCOUNT);
    }

    private RegistBankAccountEntity getRegistBankAccountEntity(RegistBankAccountCommand command) {
        return registBankAccountPort.createRegistBankAccountEntity(
                command.getMemberId(),
                command.getBankName(),
                command.getBankAccountNumber(),
                command.isValid()
        );
    }

}
