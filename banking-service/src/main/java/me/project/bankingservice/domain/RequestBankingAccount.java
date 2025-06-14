package me.project.bankingservice.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestBankingAccount {

    private String memberId;

    private String fromBankAccountName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private String depositMemberName;

    private String requestAt;

    private BankingStatus bankingStatus;

    /**
     * 입금 도메인을 생성한다.
     */
    public static RequestBankingAccount createRequestBankAccount(
            String memberId,
            String fromBankAccountName,
            String fromBankAccountNumber,
            String toBankName,
            String toBankAccountNumber,
            String depositMemberName,
            String requestAt,
            BankingStatus bankingStatus
    ) {
        return new RequestBankingAccount(
                memberId,
                fromBankAccountName,
                fromBankAccountNumber,
                toBankName,
                toBankAccountNumber,
                depositMemberName,
                requestAt,
                bankingStatus);
    }
}
