package org.example.Entidades;
//jpa
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//jpa

//jpa
@Entity //sirve para indicarle a nuestra unidad de persistencia que es una entidad y debe ser guardada como tal en la bd
@Table(name = "Articulo")//indicamos que es una tabla en la base de datos y le damos un nombre
//jpa

//lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//lombok

//para poder hacer persistente a una entidad debemos hacerla implementar la interface de Serializable, esto para convertir al objeto en una secuencia de bytes para poder almacenarlo en nuestra bd
public class Articulo implements Serializable {
    //ATRIBUTOS
    @Id//jpa, nos indica que es la clave primaria de esta tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me genera que el id sea autoincremental
    private Long idArticulo;

    //existe la etiqueta @Column(name = "Cantidad...") la cual me permite establecerle un nombre que yo quiera a las columnas de la tabla
    private int cantidad;
    private String denominacion;
    private double precio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})//usamos persist y merge porque no es una composicion entonces is se borra un articulo no se va a borrar ua categoría y ademas para que se actualicen caundo alguna se actualice
    @Builder.Default
    @JoinTable(name = "ArticuloCategoria", joinColumns = @JoinColumn(name = "idArticulo"), inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    private List<Categoria> categoria = new ArrayList<Categoria>();
    //ATRIBUTOS
}
