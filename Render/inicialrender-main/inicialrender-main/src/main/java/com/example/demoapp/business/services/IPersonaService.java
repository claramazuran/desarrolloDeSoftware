package com.example.demoapp.business.services;

import com.example.demoapp.domain.entities.Persona;

public interface IPersonaService {

    Persona crear(Persona persona);
    Persona getById(Long id);
}
