package com.rasmoo.cliente.escola.gradescurricular.controller;

import com.rasmoo.cliente.escola.gradescurricular.dto.MateriaDto;
import com.rasmoo.cliente.escola.gradescurricular.model.Response;
import com.rasmoo.cliente.escola.gradescurricular.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/materia")
public class MateriaController {

    private static final String DELETE = "DELETE";
    private static final String UPDATE = "UPDATE";
    private static final String LIST = "GET_ALL";

    @Autowired
    private IMateriaService materiaService;


    //metodo GET que retorna uma lista com TODAS as MATERIAS
    @GetMapping
    public ResponseEntity<Response<List<MateriaDto>>> listarMaterias() {
        Response<List<MateriaDto>> response = new Response<>();
        response.setData(this.materiaService.listar());
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).listarMaterias()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //metodo Get que retorna apenas UMA MATERIA
    @GetMapping("/{id}")
    public ResponseEntity<Response<MateriaDto>> consultaMateria(@PathVariable Long id) {
        Response<MateriaDto> response = new Response<>();
        MateriaDto materia = this.materiaService.consultar(id);
        response.setData(materia);//retorno do consultar
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).consultaMateria(id)).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).excluirMateria(id)).withRel(DELETE));
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).atualizarMateria(materia)).withRel(UPDATE));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //metodo POST utilizado para incluir uma NOVA MATERIA
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrarMateria(@Valid @RequestBody MateriaDto materia) {
        Response<Boolean> response = new Response<>();
        response.setData(this.materiaService.cadastrar(materia));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).cadastrarMateria(materia)).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).atualizarMateria(materia)).withRel(UPDATE));
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).listarMaterias()).withRel(LIST));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //metodo PUT utilizado para ALTERAR UMA MATERIA já cadastrada
    @PutMapping
    public ResponseEntity<Response<Boolean>>atualizarMateria(@Valid @RequestBody MateriaDto materia){
        Response<Boolean> response = new Response<>();
        response.setData(this.materiaService.atualizar(materia));
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).atualizarMateria(materia)).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).listarMaterias()).withRel(LIST));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //metodo DELETE utilizado para EXCLUIR UMA MATERIA
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> excluirMateria(@PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.materiaService.excluir(id));
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).excluirMateria(id)).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).listarMaterias()).withRel(LIST));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
