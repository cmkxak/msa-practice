package me.project.memberservice.application;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.application.port.in.RegistMemberShipCommand;
import me.project.memberservice.application.port.in.RegistMembershipUseCase;
import me.project.memberservice.application.port.out.RegistMemberShipPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RegistMemberShipService implements RegistMembershipUseCase {

    private final RegistMemberShipPort registMemberShipPort;

    @Override
    public Long regist(RegistMemberShipCommand command) {
        registMemberShipPort.registMemberShip();

        //command를 활용해 db와 통신하고 멤버의 아이디를 반환한다.
        //비즈니스 로직 입장에서는 디비가 외부 시스템
        // 포트와 어댑터를 통해야만 외부 시스템에 접근 가능.

    }
}
