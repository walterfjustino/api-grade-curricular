package com.testgb.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Transacao implements Serializable { private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Long data;
    private Integer valor;
    private Boolean duplicated;

    //CONSTRUTOR VAZIO
    public Transacao(){

    }

    //CONSTRUTOR COM PARAMETROS
    public Transacao(Integer id, String descricao, Long data, Integer valor, Boolean duplicated) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.duplicated = duplicated;
    }

    //GETTER SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Boolean getDuplicated() {
        return duplicated;
    }

    public void setDuplicated(Boolean duplicated) {
        this.duplicated = duplicated;
    }

    //HASHCODE EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao)) return false;
        Transacao transacao = (Transacao) o;
        return getId().equals(transacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
