package me.project.bankingservice.adapter.out.external;

import me.project.bankingservice.application.port.out.RequestBankAccountInfoPort;
import me.project.bankingservice.domain.BankAccount;

public class RequestAccountBankInfoAdapter implements RequestBankAccountInfoPort {
    //외부 요청 url

    @Override
    public BankAccount getBankAccountInfoPort(String bankName, String bankAccountNumber) {
        return null;
    }
}
