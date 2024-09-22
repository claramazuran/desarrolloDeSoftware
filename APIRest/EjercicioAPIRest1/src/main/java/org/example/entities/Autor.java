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
@Table(name = "Autor")
//Jpa

public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    private String nombreAutor;
    private String apellidoAutor;
    private String bibliografia;

    @ManyToMany(mappedBy = "autor")
    @Builder.Default
    private List<Libro> libro = new ArrayList<>();

}
