package me.project.memberservice.application.port.out;

import me.project.memberservice.adapter.out.persistence.MemberShipEntity;
import org.springframework.stereotype.Component;

/**
 * 이 포트는 RegistMembership을 하기 위한 내부 영역의 구현체.
 * 즉, 내부 영역의 이벤트 인터페이스를 구현하여 아웃바운드로 저장소에 멤버십을 저장하는 역할.
 */
@Component
public interface RegistMemberShipPort {


    MemberShipEntity createMemberShip(String name, String email, String address, boolean isCorp, boolean isValid);


}
