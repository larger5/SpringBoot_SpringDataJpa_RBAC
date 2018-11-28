package com.cun.exception;

public class RBACException extends RuntimeException {

    private Integer code;

    public RBACException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public RBACException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }
}
