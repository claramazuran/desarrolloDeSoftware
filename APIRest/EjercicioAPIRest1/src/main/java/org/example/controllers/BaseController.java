package org.example.controllers;

import org.example.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.io.Serializable;

//va a tener todas las operaciones basicas que deben tener nuestros controladores y va a ser de tipo generico
public interface BaseController <E extends Base, ID extends Serializable> {

    //ResponseEntity es una clase generica que recibe cualquier tipo de dato que derive de object, eso significa el <?> es el comodin de java generics
    public ResponseEntity<?> getAll();
    // Hacemos que la paginación sea opcional con una implementación por defecto
    default ResponseEntity<?> getAll(Pageable pageable) {
        throw new UnsupportedOperationException("Paginación no implementada en este controlador.");
    }
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);

}
