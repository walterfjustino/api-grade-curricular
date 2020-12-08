package com.rasmoo.cliente.escola.gradescurricular.repository;

import com.rasmoo.cliente.escola.gradescurricular.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<CursoEntity, Long> {

    @Query("select c from CursoEntity c where c.codigo = :codigo")
    public CursoEntity findCursoByCodigo(@Param("codigo") String codCurso);
}
