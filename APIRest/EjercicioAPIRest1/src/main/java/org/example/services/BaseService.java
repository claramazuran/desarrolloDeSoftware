package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.io.Serializable;
import java.util.List;

//metodos principales de base de datos, son las operaciones comunes a todo el modelo, la haemos de tipo generica porque va a poder recibir varios tipos de entidades
public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception; //nos trae una lista de todos los objetos de una misma entidad de la base de datos
    //paginacion del metodo findAll
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception; //me busca una persona en la base de datos por el id
    public E save(E entity) throws Exception; //es el alta, me guarda un objeto
    public E update(ID id, E entity) throws Exception; //actualiza un objeto
    public boolean delete(ID id) throws Exception; //elimina un objeto

}
