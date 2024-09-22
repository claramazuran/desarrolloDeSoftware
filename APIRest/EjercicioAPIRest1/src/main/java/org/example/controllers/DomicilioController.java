package org.example.controllers;

import org.example.entities.Domicilio;
import org.example.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//indicamos que es un controlador
@CrossOrigin(origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "api/v1/domicilios")//a traves de esa uri podemos acceder a los metodos de domicilio

public class DomicilioController {

    @Autowired//nos crea el constructor de la clase y spring lo activa solo
    private DomicilioService domicilioService;

    @GetMapping("")//indicamos la uri de este metodo que son las dos comillas
    //el response entity nos permite establecer que nos va a retornar las respuestas en un formato json
    public ResponseEntity<?> getAll (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findAll());//lo que hace es que si el estado de la response entity es correcto nos devuelve todas los libros que encontro en la base de datos
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }
    @GetMapping("/{id}")//en la uri se recibe el id
    public ResponseEntity<?> getOne (@PathVariable Long id){//le ponemos pathvariable porque es una variable el id que esta dentro del path
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findById(id));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @PostMapping("")//en la uri se recibe el id
    public ResponseEntity<?> save(@RequestBody Domicilio domicilio){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.save(domicilio));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @PutMapping("/{id}")//en la uri se recibe el id, es el tipo de request
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Domicilio domicilio){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.update(id, domicilio));//lo que hace es que si el estado de la response entity es correcto nos devuelve a la persona
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }

    @DeleteMapping("/{id}")//en la uri se recibe el id, es el tipo de request
    public ResponseEntity<?> delete(@PathVariable Long id){//la tenemos que declarar como que esta dentro del body
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(domicilioService.delete(id));//nos coloca un not content
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }
}
