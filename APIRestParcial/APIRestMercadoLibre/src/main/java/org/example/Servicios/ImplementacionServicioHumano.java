package org.example.Servicios;

import org.example.Entidades.Estadistica;
import org.example.Entidades.Humano;
import org.example.Repositorios.RepositorioEstadistica;
import org.example.Repositorios.RepositorioHumano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImplementacionServicioHumano extends ImplementacionServicioBase <Humano, Long> implements ServicioHumano{
    @Autowired
    private RepositorioHumano repositorioHumano;
    @Autowired
    private RepositorioEstadistica repositorioEstadistica;

    @Override
    public Humano save(Humano entity) {
        return repositorioHumano.save(entity);
    }


    @Override
    public boolean mutanteOno(Humano humano) {
        return humano.esMutante(humano.getDna());
    }

    @Override
    public Estadistica obtenerEstadistica() {
        long cantidadHumanos = repositorioEstadistica.contarHumanos();
        long cantidadMutantes = repositorioEstadistica.contarMutantes();

        double ratio = (cantidadHumanos + cantidadMutantes) > 0
                ? (double) cantidadMutantes / (cantidadHumanos + cantidadMutantes)
                : 0;
        Estadistica estadistica = Estadistica.builder()
                .fechaEstadistica(new Date())//asigna la fecha actual
                .cantidadHumanos(cantidadHumanos)
                .cantidadMutantes(cantidadMutantes)
                .ratio(ratio)
                .build();
        repositorioEstadistica.save(estadistica);

        return estadistica;
    }
}
