package me.project.memberservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.application.port.in.FindMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMembershipUseCase;
import me.project.memberservice.common.WebAdapter;
import me.project.memberservice.domain.MemberShip;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/membership")
@RestController
@WebAdapter
public class MemberShipController {

    private RegistMembershipUseCase membershipUseCase;

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

    @GetMapping
    public FindMemberShipCommand find(@RequestBody FindMemberShipRequest request) {
        return FindMemberShipCommand
                .builder()
                .name(request.getName())
                .build();
    }
}
