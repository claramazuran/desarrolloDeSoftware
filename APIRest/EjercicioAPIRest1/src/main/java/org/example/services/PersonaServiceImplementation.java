package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Persona;
import org.example.repositories.BaseRepository;
import org.example.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//Lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

@Service//indicamos que es un servicio
//implementa la interface de base service
public class PersonaServiceImplementation extends BaseServiceImplementation <Persona, Long>  implements PersonaService{

    private PersonaRepository personaRepository; // Usamos final para indicar que no cambiará

    // Constructor que inyecta el repositorio
    @Autowired
    public PersonaServiceImplementation(PersonaRepository personaRepository) {
        super(personaRepository); // Llamamos al constructor de la clase base
        this.personaRepository = personaRepository; // Asignamos el repositorio específico
    }
    //Este metodo lo realice para saber el error mas detallado de cuando hacia el metodo post o create en postman, ME SALIA EL ERROR org.springframework.transaction.UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only
    @Override
    public Persona save(Persona entity) {
        try {
            return personaRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la persona: " + e.getMessage());
        }
    }

    //es la implementacion del metodo que definimos en PersonaService, el cual se encarga de buscar una lista de personas, ya sea por jpql, metodos de queries o query de sql
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //METODO DE QUERIES
            //List<Persona> personas = personaRepository.findByNombrePersonaContainingOrApellidoPersonaContaining(filtro, filtro);

            //JPQL
            //List<Persona> personas = personaRepository.search(filtro);

            //SQL
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //search con paginacion
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //METODO DE QUERIES
            //List<Persona> personas = personaRepository.findByNombrePersonaContainingOrApellidoPersonaContaining(filtro, filtro, pageable);

            //JPQL
            //List<Persona> personas = personaRepository.search(filtro, pageable);

            //SQL
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);

            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
