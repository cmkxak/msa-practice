package me.project.memberservice.application.port.in;

import lombok.Builder;
import me.project.memberservice.common.SelfValidator;

@Builder
public class RegistMemberShipCommand extends SelfValidator<RegistMemberShipCommand> {

    /**
     * 선언적인 검증이 가능해져요.
     * SelfValidator에 의해.
     */
    private String name;
    private String email;
    private String address;
}
