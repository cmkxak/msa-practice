package me.project.payment.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberStatusResponse {

    private String memberId;

    private String memberStatus;
}
