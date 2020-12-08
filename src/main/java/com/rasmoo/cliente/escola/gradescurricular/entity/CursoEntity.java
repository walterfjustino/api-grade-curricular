package com.rasmoo.cliente.escola.gradescurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_curso")
@Data
@NoArgsConstructor
public class CursoEntity implements Serializable {

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

    //FetchType.LAZY = indica que não queremos a nossa entidade seja carregada no database até que precisemos dela
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id")//indica a chave estrangeira ou Primary key que vai ser relacionada com a entidade Matéria.
    private List<MateriaEntity> materias;
}
