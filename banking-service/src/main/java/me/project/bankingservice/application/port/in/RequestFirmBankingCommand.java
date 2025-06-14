package me.project.bankingservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import me.project.bankingservice.domain.BankingStatus;

public class RequestFirmBankingCommand {

    @NotNull
    private String memberId;

    private String fromBankAccountName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private String depositMemberName;

    private String requestAt;

    private BankingStatus bankingStatus;



}
