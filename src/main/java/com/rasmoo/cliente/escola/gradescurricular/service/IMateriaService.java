package com.rasmoo.cliente.escola.gradescurricular.service;

import com.rasmoo.cliente.escola.gradescurricular.dto.MateriaDto;

import java.util.List;

public interface IMateriaService {

    /*
     * LISTAR todas matérias.
     */
    public List<MateriaDto> listar();

    /*
     * CONSULTA uma matéria a partir do ID.
     */
    public MateriaDto consultar(final Long id);

    /*
     * CADASTRAR uma matéria.
     */
    public Boolean cadastrar(final MateriaDto materia);

    /*
     * ATUALIZA uma matéria.
     */

    public Boolean atualizar(final MateriaDto materia);

    /*
     * EXCLUI uma matéria.
     */
    public Boolean excluir(final Long id);
}

