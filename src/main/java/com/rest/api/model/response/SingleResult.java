package com.rest.api.model.response;

import lombok.Getter;
import lombok.Setter;

// 결과가 단일건인 api를 담는 모델
@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;
}
