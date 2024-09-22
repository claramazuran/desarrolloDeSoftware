package org.example.services;

import org.example.entities.Domicilio;
import org.example.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service//indicamos que es un servicio
//implementamos el servicio base
public class DomicilioService implements BaseService<Domicilio>{

    @Autowired//me hace el constructory spring lo activa solo
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            List<Domicilio> domicilio = domicilioRepository.findAll();
            return domicilio;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            return entityOptional.get();
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try{
            entity = domicilioRepository.save(entity);
            return entity;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try{
            Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
            Domicilio domicilio = domicilioOptional.get();
            domicilio = domicilioRepository.save(entity);
            return domicilio;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (domicilioRepository.existsById(id)) {
                domicilioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
