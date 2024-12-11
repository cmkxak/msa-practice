package me.project.memberservice.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;
import me.project.memberservice.domain.MemberShip;

@Builder
@Getter
@Entity
@Table(name = "membership")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String address;

    private boolean isCorp;

    private boolean isValid; //내부 시스템에 의한 관리값


    public static MemberShipEntity createMemberShipEntity(MemberShip memberShipDTO) {
        return MemberShipEntity.builder()
                .name(memberShipDTO.getName())
                .email(memberShipDTO.getEmail())
                .address(memberShipDTO.getAddress())
                .isCorp(memberShipDTO.isCorp())
                .isValid(memberShipDTO.isValid())
                .build();
    }
}
