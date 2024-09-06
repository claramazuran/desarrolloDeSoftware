package org.example.Entidades;
//jpa
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
//jpa

//jpa
@Entity//sirve para indicarle a nuestra unidad de persistencia que es una entidad y debe ser guardada como tabla
@Table(name = "Domicilio")//indicamos que es una tabla en la base de datos y le damos un nombre
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
public class Domicilio implements Serializable {
    //ATRIBUTOS
    @Id//jpa, nos indica que es la clave primaria de esta tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me genera que el id sea autoincremental
    private Long idDomicilio;

    //existe la etiqueta @Column(name = "Cantidad...") la cual me permite establecerle un nombre que yo quiera a las columnas de la tabla
    private String nombreCalle;
    private int numero;
    //ATRIBUTOS
}
