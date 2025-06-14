package me.project.memberservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.adapter.in.web.model.RegistMemberShipRequest;
import me.project.memberservice.application.port.in.RegistMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMembershipUseCase;
import me.project.memberservice.common.WebAdapter;
import me.project.memberservice.domain.MemberShip;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/membership")
@RestController
@WebAdapter
public class MemberShipController {

    private final RegistMembershipUseCase membershipUseCase;

    /**
     * 멤버십을 등록한다.
     * @param request
     * @return
     */
    @PostMapping
    public MemberShip regist(@RequestBody RegistMemberShipRequest request) {
        RegistMemberShipCommand registMemberShipCommand = getRegistMemberShipCommand(request);
        return membershipUseCase.regist(registMemberShipCommand);
    }

    private RegistMemberShipCommand getRegistMemberShipCommand(RegistMemberShipRequest request) {
        return RegistMemberShipCommand
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
    }

}
