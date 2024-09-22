package org.example.services;

import org.example.entities.Autor;
import org.example.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//Indicamos que es un servicio
@Service
//implementamos la interfaz BaseService
public class AutorService implements BaseService <Autor>{

    @Autowired//nos crea el constructor de la clase y spring lo activa solo
    private AutorRepository autorRepository;

    @Override
    @Transactional//significa que los metodos van a hacer transacciones con la base de datos, nos ahorramos de colocar lo del entity manager de envers, commit, create y rollback
    public List<Autor> findAll() throws Exception {
        try{
            List<Autor> autores = autorRepository.findAll();
            return autores;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try{
            Optional<Autor> autor1 = autorRepository.findById(id);
            return autor1.get();
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try{
            entity = autorRepository.save(entity);
            return entity;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try{
            Optional<Autor> optionalAutor = autorRepository.findById(id);//la buscamos
            Autor autor = optionalAutor.get();//se modifica
            autor = autorRepository.save(entity);//se guarda
            return autor;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)){
                autorRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
