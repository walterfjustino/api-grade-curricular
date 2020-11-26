package com.rasmoo.cliente.escola.gradescurricular.handler;

import com.rasmoo.cliente.escola.gradescurricular.model.ErrorMapResponse;
import com.rasmoo.cliente.escola.gradescurricular.model.ErrorMapResponse.ErrorMapResponseBuilder;
import com.rasmoo.cliente.escola.gradescurricular.model.ErrorResponse;
import com.rasmoo.cliente.escola.gradescurricular.model.ErrorResponse.ErrorResponseBuilder;
import com.rasmoo.cliente.escola.gradescurricular.exception.MateriaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ResourceHandler{


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMapResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m){
        Map<String,String> erros = new HashMap<String, String>();
        m.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(campo, mensagem);
        } );

        ErrorMapResponseBuilder errorMap = ErrorMapResponse.builder();
        errorMap.erros(erros).httpStatus(HttpStatus.BAD_REQUEST.value())
                             .timestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap.build());

    }

    @ExceptionHandler(MateriaException.class)
    public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException m){
       ErrorResponseBuilder erro = ErrorResponse.builder();
        erro.httpStatus(m.getHttpStatus().value());
        erro.mensagem(m.getMessage());
        erro.timestamp(System.currentTimeMillis());
        return ResponseEntity.status(m.getHttpStatus()).body(erro.build());

    }

}
