package org.example.Repositorios;

import org.example.Entidades.Estadistica;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioEstadistica extends RepositorioBase<Estadistica, Long> {

    //SQL
    @Query(
            value = "SELECT COUNT(*) FROM HUMANO WHERE HUMANO.ES_MUTANTE IS TRUE",
            nativeQuery = true
    )
    long contarMutantes();

    @Query(
            value = "SELECT COUNT(*) FROM HUMANO WHERE HUMANO.ES_MUTANTE IS FALSE",
            nativeQuery = true
    )
    long contarHumanos();
    //SQL
}
