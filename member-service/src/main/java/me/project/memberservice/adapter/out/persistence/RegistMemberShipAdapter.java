package me.project.memberservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.application.port.out.RegistMemberShipPort;
import me.project.memberservice.common.PersistenceAdapter;
import me.project.memberservice.domain.MemberShip;

@RequiredArgsConstructor
@PersistenceAdapter
public class RegistMemberShipAdapter implements RegistMemberShipPort {

    private final MemberShipRepository memberShipRepository;

    @Override
    public MemberShipEntity createMemberShip(String name, String email, String address, boolean isCorp, boolean isValid) {
        MemberShip memberShipDTO = MemberShip.createMemberShipDTO(
                name,
                email,
                address,
                isCorp,
                isValid
        );

        MemberShipEntity entity = MemberShipEntity.createMemberShipEntity(memberShipDTO);
        return memberShipRepository.save(entity);


    }
}
