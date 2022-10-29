package com.rest.api.advice.exception;
/*
통신오류를 처리할 CCommunicationException을 선언
 */
public class CCommunicationException extends RuntimeException {

    public CCommunicationException() {
        super();
    }

    public CCommunicationException(String msg) {
        super(msg);
    }

    public CCommunicationException(String msg, Throwable t) {
        super(msg, t);
    }
}
