package org.example.services;

import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.entities.Base;
import org.example.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

//Lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

//clase abstracta que implementa nuestro servicio base y dsp los otros servicios de las entidadees heredan de esta clase y los metodos
public abstract class BaseServiceImplementation <E extends Base, ID extends Serializable> implements BaseService <E, ID> {

    //instanciamos nuestro servicio base
    protected BaseRepository <E,ID> baseRepository;//usamos protected asi las clases que hereden de ella pueden acceder a este atributo como si estuviera el permiso en publico

    public BaseServiceImplementation(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    //significa que los metodos van a hacer transacciones con la base de datos, nos ahorramos de colocar lo del entity manager de envers, commit, create y rollback
    public List<E> findAll() throws Exception {

        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    //Paginacion del metodo findAll
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable){
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {

        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {

        try{
            entity = baseRepository.save(entity);
            return entity;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);//buscamos a la persona
            E entityUpdate = entityOptional.get();//se la modifica
            entityUpdate = baseRepository.save(entity);//guardamos el objeto modificado
            return entityUpdate;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
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
