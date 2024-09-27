package org.example.repositories;

import org.example.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

//es el repositorio base generico para todas nuestras entidades
@NoRepositoryBean//indicamos que no se debe instanciar el repo
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> { //E es la entidad que debe extender de base que es la clase base de las entidades y el ID que debe extender de serializable
}
