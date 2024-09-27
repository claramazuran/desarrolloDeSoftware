package org.example.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Autor;
import org.example.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder//le ponemos superbuilder porque herada de una clase
//Lombok

//Indicamos que es un servicio
@Service
//implementamos la interfaz BaseService

public class AutorServiceImplementation extends BaseServiceImplementation <Autor, Long> implements AutorService{

    private AutorRepository autorRepository; // Usamos final para indicar que no cambiará

    // Constructor que inyecta el repositorio
    @Autowired
    public AutorServiceImplementation(AutorRepository autorRepository) {
        super(autorRepository); // Llamamos al constructor de la clase base
        this.autorRepository = autorRepository; // Asignamos el repositorio específico
    }
}
