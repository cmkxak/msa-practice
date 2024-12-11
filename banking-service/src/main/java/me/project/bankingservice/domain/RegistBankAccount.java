package me.project.bankingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistBankAccount {

    private String registBankAccountId;
    private String memberId;
    private String bankName;
    private String bankAccountNumber;
    private boolean linkedStatus;

    /**
     * 계좌 등록 도메인을 생성한다.
     */
    public static RegistBankAccount createRegistBankAccount(
            String registBankAccountId,
            String memberId,
            String bankname,
            String bankAccountNumber,
            boolean linkedStatus
    ) {
        return new RegistBankAccount(
                registBankAccountId,
                memberId,
                bankname,
                bankAccountNumber,
                linkedStatus
        );
    }


}
