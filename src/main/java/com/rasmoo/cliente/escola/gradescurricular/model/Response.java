package com.rasmoo.cliente.escola.gradescurricular.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)//utilizado pois a RepresentationModel tbm possui e não vamos utilizar dela
public class Response <T> extends RepresentationModel<Response<T>> {

    private int statusCode;
    private T data; //objeto genérico q significa, q irá ser qualquer objeto que passe no Response
    private Long timestamp;


    public Response() {
        this.timestamp = System.currentTimeMillis();

    }
}