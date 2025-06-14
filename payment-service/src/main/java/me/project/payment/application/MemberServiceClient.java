package me.project.payment.application;

import me.project.payment.common.MemberLimitResponse;
import me.project.payment.common.MemberStatusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url = "${member.service.url}")
public interface MemberServiceClient {

    // 회원 상태 확인
    @GetMapping("/{memberId}")
    MemberStatusResponse getMemberStatus(@PathVariable("memberId") String memberId);

    // 회원 한도 확인
    @GetMapping("/{memberId}/limit")
    MemberLimitResponse getMemberLimit(@PathVariable("memberId") String memberId);

    @GetMapping
}
