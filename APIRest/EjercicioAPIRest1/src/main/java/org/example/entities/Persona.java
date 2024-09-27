package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//le indico el tipo de estrategia de single table, hay tres estrategias
//@DiscriminatorColumn(name = "diferenciador")//es la columna que me indica por ejemplo es para saber si es alumno o profesor
//Lombok

//Jpa
@Entity
@Table(name = "Persona")
//Jpa
public class Persona extends Base {

    //Atributos

        private String nombrePersona;
        private String apellidoPersona;
        private int dniPersona;

        @OneToOne(cascade = CascadeType.ALL)//si se borra, modifica, perisiste la persona se borra, modifica, perisiste el domicilio
        private Domicilio domicilio;

        @Builder.Default
        @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)//con orphan removal cuando se borre la persona se borran los libros que le pertenencen
        @JoinTable(name = "persona_libro", joinColumns = @JoinColumn(name = "persona_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
        private List<Libro> libro = new ArrayList<>();
    //Atributos
}
