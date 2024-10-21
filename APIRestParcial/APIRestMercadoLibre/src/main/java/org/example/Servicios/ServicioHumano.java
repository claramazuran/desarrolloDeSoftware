package org.example.Servicios;

import org.example.Entidades.Estadistica;
import org.example.Entidades.Humano;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicioHumano extends ServicioBase <Humano, Long> {
    public boolean mutanteOno(Humano entity) throws Exception;
    public Estadistica obtenerEstadistica();
}
