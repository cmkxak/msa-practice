package me.project.payment.application;

import me.project.payment.common.MoneyBalanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "money", url = "${money.service.url}")
public interface MoneyServiceClient {

    @GetMapping("/{memberId}")
    MoneyBalanceResponse getMoneyBalanceResponse(@PathVariable("memberId") String memberId);

}
