package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entities.Libro;
import org.example.repositories.LibroRepository;
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
public class LibroServiceImplementation extends BaseServiceImplementation <Libro, Long> implements LibroService{


    private LibroRepository libroRepository; // Usamos final para indicar que no cambiará

    // Constructor que inyecta el repositorio
    @Autowired
    public LibroServiceImplementation(LibroRepository libroRepository) {
        super(libroRepository); // Llamamos al constructor de la clase base
        this.libroRepository = libroRepository; // Asignamos el repositorio específico
    }
}
