package org.example.services;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Localidad;
import org.example.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

@Service//indicamos que es un servicio
//implementa la interface de base service
public class LocalidadServiceImplementation extends BaseServiceImplementation <Localidad, Long> implements LocalidadService{


    private LocalidadRepository localidadRepository; // Usamos final para indicar que no cambiará


    // Constructor que inyecta el repositorio
    @Autowired
    public LocalidadServiceImplementation(LocalidadRepository localidadRepository) {
        super(localidadRepository); // Llamamos al constructor de la clase base
        this.localidadRepository = localidadRepository; // Asignamos el repositorio específico
    }
}
