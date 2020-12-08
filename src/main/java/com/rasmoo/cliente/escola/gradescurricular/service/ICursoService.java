package com.rasmoo.cliente.escola.gradescurricular.service;

import com.rasmoo.cliente.escola.gradescurricular.entity.CursoEntity;
import com.rasmoo.cliente.escola.gradescurricular.model.CursoModel;


import java.util.List;


public interface ICursoService {



        Boolean cadastrar(CursoModel cursoModel);

        Boolean atualizar(CursoModel cursoModel);

        Boolean excluir(Long cursoId);

        CursoEntity consultarPorCodigo(String codCurso);

        List<CursoEntity> listar();

        }

