package me.project.memberservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberShipDTO {

    private String name;
    private String email;
    private String address;
    private boolean isCorp;
    private boolean isValid; //내부 시스템에 의한 관리값


    public static MemberShipDTO createMemberShipDTO(
            String name,
            String email,
            String address,
            boolean isCorp,
            boolean isValid
    ) {
        return new MemberShipDTO(
                name,
                email,
                address,
                isCorp,
                isValid
        );
    }

}
