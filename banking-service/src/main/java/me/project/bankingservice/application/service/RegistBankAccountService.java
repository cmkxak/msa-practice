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
        //1. 회원 상태 조회 (일단 생략 -> MEMBER-service가 담당..)

        //2. 계좌 상태 조회
        BankAccount account = requestBankAccountInfoPort.getBankAccountInfoPort(
                command.getBankName(), command.getBankAccountNumber()
        );

        if (account.isAccountStatusValid()) {
            RegistBankAccountEntity registBankAccountEntity = registBankAccountPort.createRegistBankAccountEntity(
                    command.getMemberId(),
                    command.getBankName(),
                    command.getBankAccountNumber(),
                    command.isValid()
            );

            return registBankAccountMapper.mapToDomain(registBankAccountEntity);
        }

        throw new CmPayExcetion(INVALID_BANK_ACCOUNT.getMessage(),
                INVALID_BANK_ACCOUNT);
    }
}
