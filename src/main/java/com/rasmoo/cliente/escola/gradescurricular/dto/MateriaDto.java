package com.rasmoo.cliente.escola.gradescurricular.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class MateriaDto {/*CAMADA DTO UTILIZADA QUANDO QUER MAPEAR PARTE DO DOMÍNIO DA APLICAÇÃO PARA UMA FORMATAÇÃO DO MODELO WEB JSON/XML;
                         //CAMADA RESPONSÁVEL POR INTERMEDIAR A CAMADA ENTIDADE E A REPRESENTAÇÃO WEB JSON/XML;
                         // RESPONSÁVEL POR CONVERSAR COM AS 2 CAMADAS E DIMINUIR QUALQUER TIPO DE PROBLEMA ENTRE ELAS;
                         // UTILIZADA PARA DEFINIR AS REGRAS DE NEGOCIO;*/

    private Long id;

    @NotBlank(message = "Informe o nome da matéria.")
    private String nome;

    @Min(value = 34, message = "Permitido o mínimo de 34 horas por matéria.")
    @Max(value = 120, message = "Permitido o máximo de 120 horas por matéria.")
    private int horas;

    @NotBlank(message = "Informe o código da matéria.")
    private String codigo;


    @Min(value = 1, message = "Permitido o mínimo de 1 vez por ano.")
    @Max(value = 2, message = "Permitido o máximo de 2 vezes por ano.")
    private int frequencia;
}
