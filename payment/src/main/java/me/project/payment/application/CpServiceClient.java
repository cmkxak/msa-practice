package me.project.payment.application;

import me.project.payment.common.CpStatusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cp", url = "${cp.service.url}")
public interface CpServiceClient {

    @GetMapping("/{cpId}")
    CpStatusResponse getCpStatus(@PathVariable("cpId") String cpId);

}
