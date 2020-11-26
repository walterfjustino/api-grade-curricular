package com.rasmoo.cliente.escola.gradescurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_materia")
@Data
@NoArgsConstructor
public class MateriaEntity implements Serializable{

    private static final long serialVersionUID = -5115709874529054925L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @Column(name = "hrs")
    private int horas;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "cod")
    private String codigo;

    @Column(name = "freq")
    private int frequencia;





}
