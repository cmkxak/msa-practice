package me.project.memberservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import me.project.memberservice.application.port.out.RegistMemberShipPort;
import me.project.memberservice.common.PersistenceAdapter;

@RequiredArgsConstructor
@PersistenceAdapter
public class RegistMemberShipAdapter implements RegistMemberShipPort {

    private final MemberShipRepository memberShipRepository;

    @Override
    public void registMemberShip() {

    }
}
