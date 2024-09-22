package org.example.entities;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "Localidad")
//Jpa
public class Localidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalidad;

    private String denominacion;
}
