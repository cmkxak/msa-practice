package me.project.bankingservice.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class RegistBankAccountCommand {

    private String memberId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;

    public RegistBankAccountCommand(String memberId, String bankName, String bankAccountNumber, boolean isValid) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;

        //validate 작업 추가
    }
}
