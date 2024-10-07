package com.example.demoapp.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//dto que me trae solo la provincia, nombre y apellido.
//LOS NOMBRES DE LOS ATRIBUTOS TIENEN QUE TENER LOS MISMOS NOMBRES QUE LA ENTIDAD PRINCIPAL Y ORIGINAL
public class PersonaShortDto {
    private String nombre;
    private String apellido;
    private String provincia;
}
