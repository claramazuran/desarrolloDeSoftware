package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "Domicilio")
//Jpa

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomicilio;
    private String calle;
    private int numero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Localidad localidad;
}
