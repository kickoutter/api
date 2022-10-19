package com.rest.api.model.response;
/*
구현1. 결과 모델의 정의 - api의 실행 결과를 담는 공통 모델
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value="응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value="응답 코드 번호 : >=0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value="응답 메시지")
    private String msg;

}
