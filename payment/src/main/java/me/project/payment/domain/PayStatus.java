package me.project.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PayStatus {

    PAY_REGIST,
    PAY_REQEUST,
    PAY_SUCCESS,
    PAY_CANCEL_REQUEST,
    PAY_CANCEL,
    PAY_NET_CANCEL_REQEUST,
    PAY_NET_CANCEL;

}
