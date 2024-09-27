package org.example.controllers;


import org.example.entities.Libro;
import org.example.services.LibroServiceImplementation;
import org.springframework.web.bind.annotation.*;

@RestController//indicamos que es un controlador
@CrossOrigin(origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "api/v1/libros")//a traves de esa uri podemos acceder a los metodos de libro

public class LibroController extends BaseControllerImplementation<Libro, LibroServiceImplementation> {
}
