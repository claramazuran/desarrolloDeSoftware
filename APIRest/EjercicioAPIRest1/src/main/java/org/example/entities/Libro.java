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
@Table(name = "Libro")
//Jpa
public class Libro implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})//usamos persist y merge porque no es una composicion entonces si se borra un libro no se va a borrar ua autor y ademas para que se actualicen cuando alguna se actualice
    @JoinTable(name = "Libro/Autor",
            joinColumns = @JoinColumn(name = "idAutor"),
            inverseJoinColumns = @JoinColumn(name = "idLibro"))
    @Builder.Default
    private List<Autor> autor = new ArrayList<>();


}
