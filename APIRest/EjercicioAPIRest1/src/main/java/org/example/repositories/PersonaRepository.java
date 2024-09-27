package org.example.repositories;

import org.example.entities.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//se conecta directamente con la base de datos
@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    //Queries
        //Metodos de queries
            //Lista de personas las cuales el nombre o apellido coincidia con os que se pasaron en el petodo
            //Tengo que pner los nombres de los atributos tal cual los tengo en mis entidades
            List<Persona> findByNombrePersonaContainingOrApellidoPersonaContaining(String nombre, String apellido);

            //paginada
            Page<Persona> findByNombrePersonaContainingOrApellidoPersonaContaining(String nombre, String apellido, Pageable pageable);

            //El metodo existByDni nos dice si existe o no una persona en la base de datos
            //boolean existByDni(int dni);
        //Metodos de queries

        //JPQL
            @Query(value = "SELECT p FROM Persona p WHERE p.nombrePersona LIKE %:Filtro% OR p.apellidoPersona LIKE %:Filtro%")//selecciono todas las personas que sean de entidad persona y se encuentren en la bd
            List<Persona> search(@Param("Filtro") String filtro);//el param me sirve para colocarle un nombre al parametro que me pasan y poder ponerlo en la consulta
            //paginada
            @Query(value = "SELECT p FROM Persona p WHERE p.nombrePersona LIKE %:Filtro% OR p.apellidoPersona LIKE %:Filtro%")//selecciono todas las personas que sean de entidad persona y se encuentren en la bd
            Page<Persona> search(@Param("Filtro") String filtro, Pageable pageable);//el param me sirve para colocarle un nombre al parametro que me pasan y poder ponerlo en la consulta

        //JPQL

        //SQL
            @Query(
                    value = "SELECT * FROM PERSONA WHERE PERSONA.NOMBRE_PERSONA LIKE %:Filtro% OR PERSONA.APELLIDO_PERSONA LIKE %:Filtro%",
                    countQuery = "SELECT count(*) FROM PERSONA",//tenemos que agregar este atributo porque sql no tiene automatica la paginacion
                    nativeQuery = true
            )
            List<Persona> searchNativo(@Param("Filtro") String filtro);
            //paginada
            @Query(
                    value = "SELECT * FROM PERSONA WHERE PERSONA.NOMBRE_PERSONA LIKE %:Filtro% OR PERSONA.APELLIDO_PERSONA LIKE %:Filtro%",
                    nativeQuery = true
            )
            Page<Persona> searchNativo(@Param("Filtro") String filtro, Pageable pageable);
        //SQL

}
