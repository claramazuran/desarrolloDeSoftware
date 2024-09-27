package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Domicilio;
import org.example.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

@Service//indicamos que es un servicio
//implementamos el servicio base
public class DomicilioServiceImplementation extends BaseServiceImplementation <Domicilio, Long> implements DomicilioService{


    private DomicilioRepository domicilioRepository; // Usamos final para indicar que no cambiará

    // Constructor que inyecta el repositorio
    @Autowired
    public DomicilioServiceImplementation(DomicilioRepository domicilioRepository) {
        super(domicilioRepository); // Llamamos al constructor de la clase base
        this.domicilioRepository = domicilioRepository; // Asignamos el repositorio específico
    }
}
