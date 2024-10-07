package com.example.demoapp.repositories;

import com.example.demoapp.domain.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

}
