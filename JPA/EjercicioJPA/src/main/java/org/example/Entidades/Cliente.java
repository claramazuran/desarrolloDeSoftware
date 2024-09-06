package org.example.Entidades;
//jpa
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
//jpa

//jpa
@Entity//sirve para indicarle a nuestra unidad de persistencia que es una entidad y debe ser guardada como tabla
@Table(name = "Cliente")//indicamos que es una tabla en la base de datos y le damos un nombre
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
public class Cliente implements Serializable {
    //ATRIBUTOS
    @Id//jpa, nos indica que es la clave primaria de esta tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me genera que el id sea autoincremental
    private Long idCliente;

    //existe la etiqueta @Column(name = "Cantidad...") la cual me permite establecerle un nombre que yo quiera a las columnas de la tabla
    private String apellido;
    private int dni;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL) //jpa, me sirve para que cuando se actualice algo de cliente se va a actualizar en domicilio.
    @JoinColumn(name = "fkDomicilio")//me crea una columna mas en la tabla cliente donde se coloca la pk del objeto domicilio
    private Domicilio domicilio;//objeto de tipo domicilio
    //ATRIBUTOS
}
