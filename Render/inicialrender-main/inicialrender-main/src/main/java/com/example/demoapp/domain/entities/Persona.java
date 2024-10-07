package com.example.demoapp.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
//NO NECESITO EL BUILDER PORQUE ESTOY USANDO POSTMAN
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;
}
