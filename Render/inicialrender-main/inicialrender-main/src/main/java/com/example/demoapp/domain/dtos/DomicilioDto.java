package com.example.demoapp.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioDto {

    private Long id;
    private String calle;
    private int numero;
    private String provincia;

}
