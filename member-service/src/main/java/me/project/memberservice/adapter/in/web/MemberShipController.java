package me.project.memberservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.application.port.in.RegistMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMembershipUseCase;
import me.project.memberservice.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequestMapping("/api/v1/membership")
@RequiredArgsConstructor
@RestController
public class MemberShipController {

    private RegistMembershipUseCase membershipUseCase;

    /**
     * 멤버십을 등록한다.
     * @param request
     * @return
     */
    @PostMapping
    Long regist(@RequestBody RegistMemberShipRequest request) {
        RegistMemberShipCommand registMemberShipCommand = RegistMemberShipCommand
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();

        return membershipUseCase.regist(registMemberShipCommand);
    }
}
