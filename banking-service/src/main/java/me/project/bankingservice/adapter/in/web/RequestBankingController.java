package me.project.bankingservice.adapter.in.web;

import me.project.bankingservice.application.port.in.RequestFirmBankingUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RequestBankingController {

    private final RequestFirmBankingUseCase requestBankingUsecase;

    public RequestBankingController(RequestFirmBankingUseCase requestBankingUsecase) {
        this.requestBankingUsecase = requestBankingUsecase;
    }
}
