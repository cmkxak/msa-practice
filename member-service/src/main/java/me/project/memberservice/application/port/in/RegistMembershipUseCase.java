package me.project.memberservice.application.port.in;

import me.project.memberservice.common.UseCase;
import me.project.memberservice.domain.MemberShip;

/**
 * 멤버십등록을 위해서 인바운드 하고 있는 상황.
 * 인터페이스로서 실제 비즈니스 로직과 어떻게 동작 될지 정의한 부분
 * 밖에서 안으로 들어오는 데이터를 정의.
 */
@UseCase
public interface RegistMembershipUseCase {

    /**
     * 커맨드 외부에서 내부로 들어오는데 있어서 Request를 그대로 주는게 아닌
     * 중간에서 커맨드라는 개념을 사용해서 이 Request를 Command로 바꾼다.
     * useCase와 직접 연결된 명령어로써 커맨드로 추상화 시키고 추상화 된 커맨드를 UseCase와 직접 붙힌다.
     *
     * 이를 통해 내부(고수준 영역)와 외부(저수준 영역)를 분리한다.
     *
     * @param command
     */
    MemberShip regist(RegistMemberShipCommand command);

}
