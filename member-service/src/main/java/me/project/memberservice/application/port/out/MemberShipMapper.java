package me.project.memberservice.application.port.out;

import me.project.memberservice.adapter.out.persistence.MemberShipEntity;
import me.project.memberservice.domain.MemberShip;
import org.springframework.stereotype.Component;

@Component
public class MemberShipMapper {

    /**
     * entity -> domain
     * @param memberShipEntity
     * @return
     */
    public MemberShip mapToDomainEntity(MemberShipEntity memberShipEntity) {
        return MemberShip.createMemberShipDTO(
                memberShipEntity.getName(),
                memberShipEntity.getEmail(),
                memberShipEntity.getAddress(),
                memberShipEntity.isCorp(),
                memberShipEntity.isValid()
        );
    }


}
