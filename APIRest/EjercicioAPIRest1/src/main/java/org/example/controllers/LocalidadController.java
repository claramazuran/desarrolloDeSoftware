package org.example.controllers;

import org.example.entities.Localidad;
import org.example.services.LocalidadServiceImplementation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//indicamos que es un controlador
@CrossOrigin(origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "api/v1/localidades")//a traves de esa uri podemos acceder a los metodos de localidad

public class LocalidadController extends BaseControllerImplementation<Localidad,LocalidadServiceImplementation  > {


}
