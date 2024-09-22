package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
//Lombok

//Jpa
@Entity
@Table(name = "Persona")
//Jpa
public class Persona implements Serializable {

    //Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPersona;

        private String nombrePersona;
        private String apellidoPersona;
        private int dniPersona;

        @OneToOne(cascade = CascadeType.ALL)
        private Domicilio domicilio;

        @Builder.Default
        @OneToMany(orphanRemoval = true)
        private List<Libro> libro = new ArrayList<>();
    //Atributos
}
