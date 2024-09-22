package org.example.services;

import java.util.List;

//metodos principales de base de datos, la haemos de tipo generica porque va a poder reciir varios tipos de entidades
public interface BaseService<E> {
    public List<E> findAll() throws Exception; //nos trae una lista de todos los objetos de una misma entidad de la base de datos
    public E findById(Long id) throws Exception; //me busca una persona en la base de datos por el id
    public E save(E entity) throws Exception; //es el alta, me guarda un objeto
    public E update(Long id, E entity) throws Exception; //actualiza un objeto
    public boolean delete(Long id) throws Exception; //elimina un objeto
}
