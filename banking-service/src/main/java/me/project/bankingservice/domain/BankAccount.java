package me.project.bankingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 외부 은행 에서 리턴해주는 데이터
 */
@AllArgsConstructor
@Getter
public class BankAccount {

    private String bankName;
    private String memberName;
    private String bankAccountNumber;
    private boolean isAccountStatusValid;
}
