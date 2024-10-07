package org.example.controllers;

import org.example.entities.Persona;
import org.example.services.PersonaServiceImplementation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//indicamos que es un controlador
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")//a traves de esa uri podemos acceder a los metodos de persona
public class PersonaController extends BaseControllerImplementation <Persona, PersonaServiceImplementation> {

    //implementamos el metodo especifico de persona, es lo mismo que la implementacion del Controlador base pero con los propios metodos de persona
    @GetMapping("/search") //en la uri de postman tenemos que agregar el search
    public ResponseEntity<?> getAll(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

    //search paginado y filtro
    @GetMapping("/searchPaged") //en la uri de postman tenemos que agregar el search
    public ResponseEntity<?> getAll(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

    /*//search paginado
    @GetMapping("/paged")//indicamos la uri de este metodo que son las dos comillas
    //el response entity nos permite establecer que nos va a retornar las respuestas en un formato json
    public ResponseEntity<?> getAll (Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));//lo que hace es que si el estado de la response entity es correcto nos devuelve todas las personas que encontro en la base de datos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde\"}");//mensaje en formato json
        }
    }*/

}
