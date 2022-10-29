package com.rest.api.model.social;
/*
Kakao 유저정보를 담을 객체 생성
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Properties;

@Getter
@Setter
@ToString
public class KakaoProfile {
    private Long id;
    private Properties properties;

    @Getter
    @Setter
    @ToString
    private static class Properties {
        private String profile_nickname;
//        private String thumbnail_image;
        private String profile_image;
    }
}
