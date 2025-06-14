package me.project.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestBankingRequest {

    private String memberId;

    private String fromBankAccountName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private String depositMemberName;

    private String requestAt;

}

