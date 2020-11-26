package com.rasmoo.cliente.escola.gradescurricular.repository;

import com.rasmoo.cliente.escola.gradescurricular.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<MateriaEntity,Long> {

}
