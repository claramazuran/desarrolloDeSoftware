package org.example.services;

import org.example.entities.Libro;
import org.example.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service//indicamos que es un servicio
//implementa la interface de base service
public class LibroService implements BaseService<Libro> {

    @Autowired//nos crea el constructor de la clase y spring lo activa solo
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
       try{
           List<Libro> libros = libroRepository.findAll();
           return libros;

       } catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    @Transactional
    public Libro findById(Long id) throws Exception {
        try{
            Optional<Libro> libro = libroRepository.findById(id);
            return libro.get();

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try{
            entity = libroRepository.save(entity);
            return entity;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try{
            Optional<Libro> libro = libroRepository.findById(id);
            Libro librito = libro.get();
            librito = libroRepository.save(entity);
            return librito;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                return true;
            } else  {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
