package com.rasmoo.cliente.escola.gradescurricular.model;

import lombok.Builder;
import lombok.Getter;

@Builder    /*utilizado quando uma classe for imutável, que não sofre alterações.*/
@Getter
public class ErrorResponse {
    private String mensagem;
    private int httpStatus;
    private Long timestamp;
}
