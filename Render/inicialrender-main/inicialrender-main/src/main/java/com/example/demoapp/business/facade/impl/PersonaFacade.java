package com.example.demoapp.business.facade.impl;

import com.example.demoapp.business.facade.IPersonaFacade;
import com.example.demoapp.business.mapper.PersonaMapper;
import com.example.demoapp.business.services.IPersonaService;
import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaFacade implements IPersonaFacade {

    @Autowired
    private IPersonaService personaService;
    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public PersonaFullDto crear(PersonaFullDto nuevaPersonaDto) {
        //Convertir el Dto en una Entidad
        var newPersona = personaMapper.personaFullDtoToPersona(nuevaPersonaDto);
        //Guardar la entidad
        var personaGuardada = personaService.crear(newPersona);
        //Devolver la nueva entida convertida en Dto al CONTROLER
        return personaMapper.personaToPersonaFullDto(personaGuardada);
    }

    @Override
    public PersonaFullDto getAllDataById(Long id) {
        //Obtener la persona
        var persona = personaService.getById(id);
        //Devolver la persona convertida al Dto con todos los datos, Y SE CONVIERTE A JSON
        return personaMapper.personaToPersonaFullDto(persona);
    }

    @Override
    public PersonaShortDto getShortDataById(Long id) {
        //Obtener la persona
        var persona = personaService.getById(id);
        //Devolver la persona convertida al Dto con pocos datos
        return personaMapper.personaToPersonaShortDto(persona);
    }
}
