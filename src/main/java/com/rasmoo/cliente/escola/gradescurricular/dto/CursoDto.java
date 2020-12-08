/*package com.rasmoo.cliente.escola.gradescurricular.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import javax.validation.constraints.NotBlank;


@Data
@EqualsAndHashCode(callSuper = false)//utilizado pois a RepresentationModel tbm possui e não vamos utilizar dela
@NoArgsConstructor
public class CursoDto extends RepresentationModel <CursoDto> {


    private Long id;

    @NotBlank(message = "Informe o nome do curso.")
    private String nome;

    @NotBlank(message = "Informe a quantidade de horas.")
    private int horas;

    @NotBlank(message = "Informe o código do curso")
    private String codigo;

}
*/