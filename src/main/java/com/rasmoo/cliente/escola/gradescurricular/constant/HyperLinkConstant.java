package com.rasmoo.cliente.escola.gradescurricular.constant;

import lombok.Getter;

@Getter
public enum HyperLinkConstant {

    ATUALIZAR("UPDATE"),
    EXCLUIR("DELETE"),
    LISTAR("GET_ALL"),
    CONSULTAR("GET");

    private final String valor;


    HyperLinkConstant(String valor) {
        this.valor = valor;
    }
}
