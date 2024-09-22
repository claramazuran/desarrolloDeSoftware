package org.example;

import org.example.entities.*;
import org.example.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Aplication {
    //el logger es una herramienta de registro que permite registrar mensajes
    private static final Logger logger = LoggerFactory.getLogger(Inicial1Aplication.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    public static void main(String[] args) {
        SpringApplication.run(Inicial1Aplication.class, args);

        System.out.println("funcionando");
    }




    @Bean
    @Transactional
    //el commandLineRunner me permite que todo lo de aca abajo se ejcute una vez iniciada la app
    CommandLineRunner init(PersonaRepository personaRepository,
                           DomicilioRepository domicilioRepository,
                           AutorRepository autorRepository,
                           LibroRepository libroRepository,
                           LocalidadRepository localidadRepository) {
        return args -> {
            // Creo un objeto persona
            Persona per1 = Persona.builder()
                    .nombrePersona("Alberto")
                    .apellidoPersona("Cortez")
                    .build();

            Domicilio dom1 = Domicilio.builder()
                    .calle("Tanat")
                    .numero(239)
                    .build();

            per1.setDomicilio(dom1);

            personaRepository.save(per1);

// Creo otra persona
            Persona per2 = Persona.builder()
                    .nombrePersona("Alicia")
                    .apellidoPersona("Calderon")
                    .build();

            Domicilio dom2 = Domicilio.builder()
                    .calle("Viognier")
                    .numero(339)
                    .build();

            per2.setDomicilio(dom2);
            personaRepository.save(per2);

            //creo una localidad
            Localidad localidad1 = Localidad.builder()
                    .denominacion("Carrodilla")
                    .build();

            //se setean las localidades para los domicilios
            dom1.setLocalidad(localidad1);
            dom2.setLocalidad(localidad1);
            localidadRepository.save(localidad1);

            //creo dos libro
            Libro libro1 = Libro.builder()
                    .titulo("20 Leguas de Viaje Submarino")
                    .build();

            Libro libro2 = Libro.builder()
                    .titulo("Harry Potter")
                    .build();

            //creo dos autor
            Autor autor1 = Autor.builder()
                    .nombreAutor("Julio")
                    .apellidoAutor("Verne")
                    .build();

            autorRepository.save(autor1);

            // Asociar libros con el autor
            libro1.setAutor(List.of(autor1)); // Establecer la relación
            libro2.setAutor(List.of(autor1)); // Establecer la relación

            libroRepository.save(libro1);
            libroRepository.save(libro2);

            //relaciona la persona con el libro
            per1.getLibro().add(libro1);
            per2.getLibro().add(libro2);

            // Lo grabo a través del repositorio de Spring

            // Guardar las personas con las relaciones actualizadas
            personaRepository.save(per1);
            personaRepository.save(per2);



            List<Persona> recuperadas = personaRepository.findAll();
            System.out.println(recuperadas);

            logger.info("Detalles de la persona: {}", recuperadas);




            Optional<Persona> recuperada = personaRepository.findById(1L);
            System.out.println(recuperada);

            logger.info("Detalles de la persona: {}", recuperada);


            dom1.setCalle("Rodriguezaaaa");

            personaRepository.save(per1);




        };

    };




}
