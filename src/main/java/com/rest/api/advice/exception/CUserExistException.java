package com.rest.api.advice.exception;
/*
기 회원 예외 처리 CUserExistException 추가
: 이미 가입 회원인데 가입 하려고 하면 예외 처리
 */
public class CUserExistException extends RuntimeException {
    public CUserExistException() {
        super();
    }

    public CUserExistException(String msg) {
        super(msg);
    }

    public CUserExistException(String msg, Throwable t) {
        super(msg, t);
    }
}
