package com.rasmoo.cliente.escola.gradescurricular.controller;

import com.rasmoo.cliente.escola.gradescurricular.dto.MateriaDto;
import com.rasmoo.cliente.escola.gradescurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradescurricular.repository.IMateriaRepository;
import com.rasmoo.cliente.escola.gradescurricular.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/materia")
public class MateriaController {


    @Autowired
    private IMateriaService materiaService;


    //metodo GET que retorna uma lista com TODAS as MATERIAS
    @GetMapping
    public ResponseEntity<List<MateriaDto>> listarMaterias() {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.listar());
    }

    //metodo Get que retorna apenas UMA MATERIA
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDto> consultaMateria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.consultar(id));
    }

    //metodo POST utilizado para incluir uma NOVA MATERIA
    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@Valid @RequestBody MateriaDto materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.materiaService.cadastrar(materia));
    }

    //metodo PUT utilizado para ALTERAR UMA MATERIA já cadastrada
    @PutMapping
    public ResponseEntity<Boolean>atualizarMateria(@Valid @RequestBody MateriaDto materia){
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizar(materia));
    }

    //metodo DELETE utilizado para EXCLUIR UMA MATERIA
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluir(id));
    }

}
