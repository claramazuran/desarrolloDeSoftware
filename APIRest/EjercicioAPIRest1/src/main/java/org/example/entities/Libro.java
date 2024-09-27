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
@Table(name = "Libro")
//Jpa
public class Libro extends Base{

    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)//si se actualiza la clase autor entonces se actualiza para libro
    @JoinTable(name = "Libro/Autor",
            joinColumns = @JoinColumn(name = "idAutor"),
            inverseJoinColumns = @JoinColumn(name = "idLibro"))
    @Builder.Default
    private List<Autor> autor = new ArrayList<>();


}
