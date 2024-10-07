package com.example.demoapp.business.facade;

import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;

public interface IPersonaFacade {

    PersonaFullDto crear(PersonaFullDto nuevaPersonaDto);

    PersonaFullDto getAllDataById(Long id);

    PersonaShortDto getShortDataById(Long id);

}
