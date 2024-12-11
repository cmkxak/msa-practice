package me.project.common.Exception;

import lombok.Getter;

@Getter
public class CmPayExcetion extends RuntimeException {
    private final ErrorCode errorCode;

    public CmPayExcetion(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        MEMBER_NOT_FOUND(10000, "회원을 찾을 수 없습니다."),
        INVALID_MEMBER(10001, "유효하지 않은 회원입니다."),
        INSUFFICIENT_BALANCE(20000, "잔액이 부족합니다.");

        private final int code;
        private final String message;

        ErrorCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
