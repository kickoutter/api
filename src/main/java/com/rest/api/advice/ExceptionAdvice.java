package com.rest.api.advice;
/*
api 처리 중 특정한 Exception 발생할 때 공통으로 처리하는 방법.
Spring의 ControllerAdvice annotation 이용
 */

import com.rest.api.advice.exception.CUserNotFoundException;
import com.rest.api.model.response.CommonResult;
import com.rest.api.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice // 예외발생시 json형대로 결과 반환하려면 사용
public class ExceptionAdvice {

    private final ResponseService responseService;

//    @ExceptionHandler(Exception.class) // Exception 발생시 Handler로 처리
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
//        return responseService.getFailResult();
//    }

    @ExceptionHandler(CUserNotFoundException.class) // Exception 발생시 Handler로 처리
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFondException(HttpServletRequest request, CUserNotFoundException e) {
        return responseService.getFailResult();
    }

}
