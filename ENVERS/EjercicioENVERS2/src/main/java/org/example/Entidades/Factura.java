package org.example.Entidades;
//jpa
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//jpa
@Entity//sirve para indicarle a nuestra unidad de persistencia que es una entidad y debe ser guardada como tabla
@Table(name = "Factura")//indicamos que es una tabla en la base de datos y le damos un nombre
//jpa


//lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//lombok

//envers
@Audited//indico que la entidad se va a auditar
//envers

//para poder hacer persistente a una entidad debemos hacerla implementar la interface de Serializable, esto para convertir al objeto en una secuencia de bytes para poder almacenarlo en nuestra bd
public class Factura implements Serializable {
    //ATRIBUTOS
    @Id //jpa, nos indica que es la clave primaria de esta tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me genera que el id sea autoincremental
    private Long idFactura;

    //existe la etiqueta @Column(name = "Cantidad...") la cual me permite establecerle un nombre que yo quiera a las columnas de la tabla
    private String fecha;
    private int numero;
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkCliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//le ponemos all porque si se borra la factura se borran los detalles, ya que es una composicion. El atributo orphanRemoval lo que me hace es eliminar todos los detalles cuando se elimina la factura
    @Builder.Default//si no coloco esto no me inicializa ni me crea el arrayList
    private List<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();
    //ATRIBUTOS
}
