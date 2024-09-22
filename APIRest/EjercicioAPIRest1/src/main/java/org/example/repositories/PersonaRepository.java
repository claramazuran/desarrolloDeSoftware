package org.example.repositories;

import org.example.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//se conecta directamente con la base de datos
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
