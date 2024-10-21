package org.example.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "Estadistica")
public class Estadistica extends EntidadBase{

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstadistica;
    private long cantidadHumanos;
    private long cantidadMutantes;
    private double ratio;
}
