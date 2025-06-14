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
        /* Member, 1xxxxx*/
        MEMBER_NOT_FOUND(10000, "회원을 찾을 수 없습니다."),
        INVALID_MEMBER(10001, "유효하지 않은 회원입니다."),
        EXTERNAL_ERROR(10002, "외부사와 통신에 실패했습니다."),

        /* Money, 2xxxxx */
        INSUFFICIENT_BALANCE(20000, "잔액이 부족합니다."),
        INVALID_PAY_AMOUNT(20001, "결제금액은 잔액보다 클 수 없습니다."),

        /* LIMIT, 3xxxxx*/
        DAY_LIMIT_EXCEEDED(30000, "일 한도가 초과되었습니다."),
        MONTH_LIMIT_EXCEEDED(30001, "월 한도가 초과되었습니다."),

        /* CP, 4xxxxx */
        INVALID_CP(40000, "유효하지 않은 가맹점입니다."),

        /* PAY, 5xxxxx */
        NOT_FOUND_PAY(50000, "존재하지 않는 결제 원장 입니다."),

        INVALID_BANK_ACCOUNT(60000, "유효하지 않은 계좌 정보 입니다.");

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
