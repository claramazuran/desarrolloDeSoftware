package audit;

import config.CustomRevisionListener;
import lombok.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REVISION_INFO")
//le indicamos a envers que esta es la entidad revision
@RevisionEntity(CustomRevisionListener.class)

//lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//lombok

public class Revision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")//me genera que el id sea secuencial y la tabla que va a generar la secuencia se llama "revision_Seq"
    @SequenceGenerator(name = "revision_seq", sequenceName = "rbac.seq_revision_id")//me genera una tabla
    @RevisionNumber//indica que este es el nro de revision
    private Long IdRevision;
    //como el tipo de dato es date esta etiqueta me indica si quiero guardar la fecha como en sql o timestamp

    @Column(name = "Revision_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp//le indica a envers que va a ser la fecha de la revision
    private Date fechaRevision;

}