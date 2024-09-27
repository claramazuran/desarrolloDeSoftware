package org.example.controllers;

import org.example.entities.Base;
import org.example.services.BaseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



public abstract class BaseControllerImplementation <E extends Base, S extends BaseServiceImplementation<E,Long>> implements BaseController <E, Long>{ //en vez de recibir un id recibe un servicio
    @Autowired
    protected S servicio;


    @GetMapping("")//indicamos la uri de este metodo que son las dos comillas
    //el response entity nos permite establecer que nos va a retornar las respuestas en un formato json
    public ResponseEntity<?> getAll (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());//lo que hace es que si el estado de la response entity es correcto nos devuelve todas las personas que encontro en la base de datos
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }
    //paginacion del getAll
    @GetMapping("/paged")//indicamos la uri de este metodo que son las dos comillas
    //el response entity nos permite establecer que nos va a retornar las respuestas en un formato json
    public ResponseEntity<?> getAll (Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));//lo que hace es que si el estado de la response entity es correcto nos devuelve todas las personas que encontro en la base de datos
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @GetMapping("/{id}")//en la uri se recibe el id
    public ResponseEntity<?> getOne (@PathVariable Long id){//le ponemos pathvariable porque es una variable el id que esta dentro del path
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @PostMapping("")//en la uri se recibe el id
    public ResponseEntity<?> save(@RequestBody E entity){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");//mensaje en formato json
        }
    }

    @PutMapping("/{id}")//en la uri se recibe el id, es el tipo de request
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @DeleteMapping("/{id}")//en la uri se recibe el id, es el tipo de request
    public ResponseEntity<?> delete(@PathVariable Long id){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));//nos coloca un not content
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }
}
