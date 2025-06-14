package me.project.bankingservice.application.port.in;

import org.springframework.stereotype.Component;

@Component
public interface RequestFirmBankingUseCase {

    void requestFirmBanking(RequestFirmBankingCommand command);
}
