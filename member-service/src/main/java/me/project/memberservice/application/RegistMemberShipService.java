package me.project.memberservice.application;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.adapter.out.persistence.MemberShipEntity;
import me.project.memberservice.application.port.in.RegistMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMembershipUseCase;
import me.project.memberservice.application.port.out.MemberShipMapper;
import me.project.memberservice.application.port.out.RegistMemberShipPort;
import me.project.memberservice.domain.MemberShip;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RegistMemberShipService implements RegistMembershipUseCase {

    private final RegistMemberShipPort registMemberShipPort;
    private final MemberShipMapper memberShipMapper;

    @Override
    public MemberShip regist(RegistMemberShipCommand command) {
        MemberShipEntity entity = registMemberShipPort.createMemberShip(
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.isCorp(),
                command.isValid()
        );
        return memberShipMapper.mapToDomainEntity(entity);
    }

}
