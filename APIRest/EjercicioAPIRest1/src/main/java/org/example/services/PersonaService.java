package org.example.services;

import org.example.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//la usamos para poner los metodos especificos de personaRepository
public interface PersonaService extends BaseService <Persona, Long>{

    //este metodo es un search generico, es decir lo utilizamos para buscar personas que cumplan con el filtro ya sea por jpql, metodos queires o query sql
    List<Persona> search(String filtro) throws Exception;
    //search con paginacion
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
