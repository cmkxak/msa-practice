package me.project.memberservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistMemberShipRequest {

    private String name;

    private String address;

    private String email;

    private boolean isCorp;

}
