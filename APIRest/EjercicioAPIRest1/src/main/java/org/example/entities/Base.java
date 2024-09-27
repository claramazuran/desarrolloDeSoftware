package org.example.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

//Lombok
@MappedSuperclass //significa que es la clase de la que hereden el resto de las entidades
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//Lombok

public class Base implements Serializable { //ponemos que implementa serializable asi ya las que herenden de base tambien implementan serializable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
