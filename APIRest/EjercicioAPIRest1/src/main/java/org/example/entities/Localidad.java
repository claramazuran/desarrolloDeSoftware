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
@Table(name = "Localidad")
//Jpa
public class Localidad extends Base {

    private String denominacion;
}
