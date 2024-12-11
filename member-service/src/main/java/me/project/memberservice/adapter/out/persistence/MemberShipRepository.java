package me.project.memberservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShipEntity, Long> {

}
