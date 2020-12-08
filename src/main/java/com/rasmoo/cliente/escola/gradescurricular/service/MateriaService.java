package com.rasmoo.cliente.escola.gradescurricular.service;

import com.rasmoo.cliente.escola.gradescurricular.constant.Mensagens;
import com.rasmoo.cliente.escola.gradescurricular.controller.MateriaController;
import com.rasmoo.cliente.escola.gradescurricular.dto.MateriaDto;
import com.rasmoo.cliente.escola.gradescurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradescurricular.exception.MateriaException;
import com.rasmoo.cliente.escola.gradescurricular.repository.IMateriaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.rasmoo.cliente.escola.gradescurricular.constant.Mensagens.ERRO_GENERICO;
import static com.rasmoo.cliente.escola.gradescurricular.constant.Mensagens.ERRO_MATERIA_NAO_ENCONTRADA;


@CacheConfig(cacheNames = "materia")//centraliza todos os caches tornando default, e pode utilizar outros caches juntos.
@Service
public class MateriaService implements IMateriaService {

    private final IMateriaRepository materiaRepository;
    private final ModelMapper mapper;

    //Utilizado como melhores práticas e tendo o autowired no construtor,
    // todos os autowired vem dos parametros do construtor, desse modo fica centralizado.
    @Autowired
    public MateriaService(IMateriaRepository materiaRepository){
        this.mapper = new ModelMapper();
        this.materiaRepository = materiaRepository;
    }


    //METODO GET-LIST
    @CachePut(unless = "#result.size()<3")//Quando o resultado da lista for menor que 3 ele não utiliza o cache
    @Override
    public List<MateriaDto> listar() {
        try {
            List<MateriaDto> materiaDto = this.mapper.map(this.materiaRepository.findAll(),new TypeToken<List<MateriaDto>>() {}.getType());
            materiaDto.forEach(materia ->
                    materia.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).listarMaterias()).withSelfRel()));
            return materiaDto;
        } catch (Exception e) {
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //METODO GET-findById
    @CachePut(key = "#id")//quando informado # identifica a variavel será utilizada em cache
    @Override
    public MateriaDto consultar(Long id) {
        try {
            Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
            if (materiaOptional.isPresent()) {
               return this.mapper.map(materiaOptional.get(),MateriaDto.class);
            }
            throw new MateriaException(ERRO_MATERIA_NAO_ENCONTRADA.getValor(), HttpStatus.NOT_FOUND);
        } catch (MateriaException m) {
            throw m;
        } catch (Exception e){
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //METODO GET-LIST HorarioMinimo
    @CachePut(unless = "#result.size()<3")//
    @Override
    public List<MateriaDto> listarPorHorarioMinimo(int horaMinima) {
        try {
            List<MateriaDto> materiaDto = this.mapper.map(this.materiaRepository.findByHoraMinima(horaMinima),new TypeToken<List<MateriaDto>>(){}.getType());
            materiaDto.forEach(materia ->
                    materia.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).consultaMateria(materia.getId())).withSelfRel()));
            return materiaDto;
        }catch (MateriaException e){
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    //METODO GET-LIST Frequencia
    @CachePut(unless = "#result.size()<3")//
    @Override
    public List<MateriaDto> listarPorFrequencia(int frequencia) {
        try {
            List<MateriaDto> materiaDto = this.mapper.map(this.materiaRepository.findByFrequencia(frequencia), new TypeToken<List<MateriaDto>>() {
            }.getType());
            materiaDto.forEach(materia ->
                    materia.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).consultaMateria(materia.getId())).withSelfRel()));
            return materiaDto;
        } catch (MateriaException e) {
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @Override
    public Boolean cadastrar(MateriaDto materia) {
        try {
            if(materia.getId() != null) {
                throw new MateriaException(Mensagens.ERRO_ID_INFORMADO.getValor(),
                        HttpStatus.BAD_REQUEST);
            }

            if (this.materiaRepository.findByCodigo(materia.getCodigo()) != null) {
                throw new MateriaException(Mensagens.ERRO_MATERIA_CADASTRADA_ANTERIORMENTE.getValor(),
                        HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(materia);
        } catch (MateriaException m) {
            throw m;
        } catch (Exception e) {
            throw new MateriaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //METODO PUT
    @CacheEvict(key = "#materia.id") //Responsável por limpar os caches
    @Override
    public Boolean atualizar(MateriaDto materia) {
        try {
            this.consultar(materia.getId()); /*buscamos pela materia que gostaríamos de atualizar e verifica se existe o Id para atualizar*/
            MateriaEntity materiaEntityAtualizada = this.mapper.map(materia,MateriaEntity.class);

            this.materiaRepository.save(materiaEntityAtualizada); //salvamos as alteracoes

            return Boolean.TRUE;

        }catch (MateriaException m) {
            throw m;
        } catch (Exception e){
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //METODO DELETE
    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.materiaRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (MateriaException m) {
            throw m;
        }catch (Exception e){
            throw new MateriaException(ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private Boolean cadastrarOuAtualizar(MateriaDto materia) {
        MateriaEntity materiaEnt = this.mapper.map(materia, MateriaEntity.class);
        this.materiaRepository.save(materiaEnt);
        return Boolean.TRUE;
    }
}
