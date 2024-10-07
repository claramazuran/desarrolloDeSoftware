package org.example.Controladores;

import org.example.Entidades.Humano;
import org.example.Servicios.ImplementacionServicioBase;
import org.example.Servicios.ImplementacionServicioHumano;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que es un controlador
@CrossOrigin (origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "/api/v1/mutantes")//a travez de esta uri accedemos a los metodos de humano

public class ControladorHumano extends ImplementacionControladorBase <Humano, ImplementacionServicioBase<Humano, Long>> {
//    public ResponseEntity<?> getAllMutants();
//    public ResponseEntity<?>  getAllNoMutants();
}
