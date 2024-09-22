package org.example.services;

import org.example.entities.Localidad;
import org.example.entities.Persona;
import org.example.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service//indicamos que es un servicio
//implementa la interface de base service
public class LocalidadService implements BaseService <Localidad>{

    @Autowired//nos crea el constructor de la clase y spring lo activa solo
    private LocalidadRepository localidadRepository;


    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try {
            List<Localidad> localidades = localidadRepository.findAll();
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(Long id) throws Exception {
        try {
            Optional<Localidad> localidadOptional = localidadRepository.findById(id);
            return localidadOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try {
            entity = localidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {
            Optional<Localidad> entityOptional = localidadRepository.findById(id);//buscamos a la persona
            Localidad localidad = entityOptional.get();//se la modifica
            localidad = localidadRepository.save(entity);//guardamos el objeto modificado
            return localidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)) {
                localidadRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
