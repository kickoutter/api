package com.rest.api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 결과가 여러건인 api를 담는 모델
@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;


}
