package org.example.services;

import org.example.entities.Persona;
import org.example.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;//debo poner jakarta en vez de javax para que sea compatible con spring boot
import java.util.List;
import java.util.Optional;

@Service//indicamos que es un servicio
//implementa la interface de base service
public class PersonaService implements BaseService<Persona> {

    @Autowired//nos crea el constructor de la clase y spring lo activa solo
    private PersonaRepository personaRepository;

    @Override
    @Transactional//significa que los metodos van a hacer transacciones con la base de datos, nos ahorramos de colocar lo del entity manager de envers, commit, create y rollback
    public List<Persona> findAll() throws Exception {

        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {

        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            return entityOptional.get();
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {

        try{
            entity = personaRepository.save(entity);
            return entity;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);//buscamos a la persona
            Persona persona = entityOptional.get();//se la modifica
            persona = personaRepository.save(entity);//guardamos el objeto modificado
            return persona;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }

        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
