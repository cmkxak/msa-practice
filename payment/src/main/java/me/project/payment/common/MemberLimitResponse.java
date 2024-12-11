package me.project.payment.common;

import lombok.Getter;

@Getter
public class MemberLimitResponse {

    private String memberId;

    private Long dayLimitAmount;

    private Long monthLimitAmount;
}
