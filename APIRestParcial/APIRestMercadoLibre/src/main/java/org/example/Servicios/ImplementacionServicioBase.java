package org.example.Servicios;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.Entidades.EntidadBase;
import org.example.Repositorios.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


public abstract class ImplementacionServicioBase <E extends EntidadBase, ID extends Serializable> implements ServicioBase <E, ID>{

    //instanciamos nuestro servicio base
    @Autowired
    protected RepositorioBase<E,ID> repoBase;//usamos protected asi las clases que hereden de ella pueden acceder a este atributo como si estuviera el permiso en publico

    public ImplementacionServicioBase(RepositorioBase<E, ID> repoBase) {
        this.repoBase = repoBase;
    }

    @Override
    @Transactional
    //significa que los metodos van a hacer transacciones con la base de datos, nos ahorramos de colocar lo del entity manager de envers, commit, create y rollback
    public List<E> findAll() throws Exception {

        try {
            List<E> entities = repoBase.findAll();
            return entities;
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {

        try {
            Optional<E> entityOptional = repoBase.findById(id);
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
            entity = repoBase.save(entity);
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
            Optional<E> entityOptional = repoBase.findById(id);//buscamos a la persona
            E entityUpdate = entityOptional.get();//se la modifica
            entityUpdate = repoBase.save(entity);//guardamos el objeto modificado
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
            if (repoBase.existsById(id)) {
                repoBase.deleteById(id);
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
