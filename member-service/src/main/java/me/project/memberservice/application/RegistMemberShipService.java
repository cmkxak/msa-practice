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

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RegistMemberShipService implements RegistMembershipUseCase {

    private final RegistMemberShipPort registMemberShipPort; //내부 영역이 외부 영역에 의존하는게 아닐까 ?
    private final MemberShipMapper memberShipMapper;

    //command를 활용해 db와 통신하고 멤버십 DTO를 반환한다.
    //비즈니스 로직 입장에서는 디비가 외부 시스템
    // 포트와 어댑터를 통해야만 외부 시스템에 접근 가능.
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
