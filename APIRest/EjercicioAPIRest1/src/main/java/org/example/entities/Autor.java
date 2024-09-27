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
//Lombok

//Jpa
@Entity
@Table(name = "Autor")
//Jpa

public class Autor extends Base {

    private String nombreAutor;
    private String apellidoAutor;

    @Column(name = "Biografia", length = 1500)//tiene hasta 1500 caracteres
    private String biografia;

    @ManyToMany(mappedBy = "autor")
    @Builder.Default
    private List<Libro> libro = new ArrayList<>();

}
