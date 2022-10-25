package com.rest.api.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
3번 : Jwt토큰으로 api를 호출하였으나 해당 리소스에 대한 권한이 없는 경우
에 대한 해결책 => Jwt토큰은 정상이라는 가정하에 Jwt토큰이 가지지 못한 권한의 리소스를 접근할 때 발생하는 오류로서
=> SpringSecurity에서 제공하는 AccessDeniedHandler를 상속받아 커스터마이징 해야됨, 예외 발생할 때
handler에서는 /exception/accessdenied로 포워딩되도록 설정
 */

@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        response.sendRedirect("/exception/accessdenied");
    }
}
