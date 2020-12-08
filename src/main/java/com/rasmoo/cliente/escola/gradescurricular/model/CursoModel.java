package com.rasmoo.cliente.escola.gradescurricular.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
public class CursoModel {


    private Long id;

    @NotBlank(message = "Nome deve ser preenchido")
    @Size(max = 30,min = 10)
    private String nome;

    @NotBlank (message = "Código deve ser preenchido")
    @Size(max = 5,min = 2)
    private String codCurso;

    private List<Long> materias;
}