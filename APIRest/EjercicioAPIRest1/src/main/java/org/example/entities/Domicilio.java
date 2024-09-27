package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

//Jpa
@Entity
@Table(name = "Domicilio")
//Jpa

public class Domicilio extends Base {

    private String calle;
    private int numero;

    //con el atributo optional = false establecemos que la relacion no puede ser nula
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)//cuando se persiste a la persona con su domicilio se vuelve a poner en estado activo a la localidad ya antes creada. NO USAMOS PERSIST PORQUE LA LOCALIDAD YA EXISTE
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
