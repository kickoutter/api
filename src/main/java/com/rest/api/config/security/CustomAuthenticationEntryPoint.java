package com.rest.api.config.security;
/*
온전한 Jwt가 전달 안될 경우, 토큰인증처리 자체가 불가능 -> 이런경우 토큰검증 단에서 프로세스 끝남
-> 따라서 해당 예외 잡으려면 SpringSecurity에서 제공하는 AuthenticationEntryPoint 상속받아 재정의해야됨
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        response.sendRedirect("/exception/entrypoint");
    }
}
