package com.rasmoo.cliente.escola.gradescurricular.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ErrorMapResponse {

    private int httpStatus;
    private Map<String,String> erros;
    private Long timestamp;
}
