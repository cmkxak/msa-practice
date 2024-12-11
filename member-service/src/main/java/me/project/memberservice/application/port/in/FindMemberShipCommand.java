package me.project.memberservice.application.port.in;

import lombok.Builder;
import lombok.Getter;
import me.project.memberservice.common.SelfValidator;

@Getter
@Builder
public class FindMemberShipCommand extends SelfValidator<FindMemberShipCommand> {

    private String name;
}
