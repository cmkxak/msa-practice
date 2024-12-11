package me.project.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistBankAccountRequest {

    private String memberId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;

}
