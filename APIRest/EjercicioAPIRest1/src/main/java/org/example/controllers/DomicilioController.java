package org.example.controllers;

import org.example.entities.Domicilio;
import org.example.services.DomicilioServiceImplementation;
import org.springframework.web.bind.annotation.*;

@RestController//indicamos que es un controlador
@CrossOrigin(origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "api/v1/domicilios")//a traves de esa uri podemos acceder a los metodos de domicilio

public class DomicilioController extends BaseControllerImplementation<Domicilio, DomicilioServiceImplementation> {
}
