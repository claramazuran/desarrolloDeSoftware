package org.example.Controladores;

import org.example.Entidades.Humano;
import org.example.Servicios.ImplementacionServicioHumano;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //indica que es un controlador
@CrossOrigin (origins = "*")//permite dar el acceso a nuestra api desde distintos origenes o clientes, en este caso indicamos que se puede acceder desde cualquier origen
@RequestMapping(path = "/mutants")//a travez de esta uri accedemos a los metodos de entity

public class ControladorHumano extends ImplementacionControladorBase <Humano, ImplementacionServicioHumano> {

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Humano entity) {
        boolean esMutante = servicio.mutanteOno(entity);
        System.out.println("Es mutante: " + esMutante);
        if (esMutante) {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(servicio.save(entity));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Humano entity) {
        try {
            boolean esMutante = servicio.mutanteOno(entity);

            if (esMutante) {
                return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(servicio.update(id, entity));
            }

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> realizarEstadistica() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.obtenerEstadistica());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

}
