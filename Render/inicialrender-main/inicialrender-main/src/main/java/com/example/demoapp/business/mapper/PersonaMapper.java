/*

Te explico el código que compartiste:

1. Paquete e importaciones:

El código pertenece al paquete com.example.demoapp.business.mapper.
Importa las clases necesarias para trabajar con MapStruct y las entidades y DTOs involucrados:
PersonaFullDto, PersonaShortDto, Domicilio y Persona (entidades del dominio).
Mapper y Mapping (anotaciones de MapStruct).
2. Interfaz PersonaMapper:

Esta interfaz define los métodos de mapeo que se utilizarán para convertir entre entidades y DTOs.
Está anotada con @Mapper(componentModel = "spring"), lo que indica a MapStruct que genere la implementación de los métodos de mapeo y la integre a Spring como un componente.
3. Métodos de mapeo:

personaToPersonaFullDto(Persona persona): Mapea una entidad Persona a un DTO PersonaFullDto.
personaFullDtoToPersona(PersonaFullDto personaFullDto): Mapea un DTO PersonaFullDto a una entidad Persona.
personaToPersonaShortDto(Persona persona): Mapea una entidad Persona a un DTO PersonaShortDto. Tiene la anotación especial @Mapping(source = "domicilio.provincia", target = "provincia") para indicar que la propiedad provincia del DTO se debe mapear desde la propiedad provincia del objeto Domicilio dentro de la entidad Persona.
En resumen, este código define un Mapper que permite convertir entre entidades Persona y DTOs PersonaFullDto y PersonaShortDto. MapStruct se encargará de generar la implementación de los métodos de mapeo en tiempo de compilación, simplificando el proceso de conversión.

*/



package com.example.demoapp.business.mapper;

import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import com.example.demoapp.domain.entities.Domicilio;
import com.example.demoapp.domain.entities.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//MAPSTRUCT, es un componente de spring
@Mapper(componentModel = "spring")
public interface PersonaMapper {

    //recibimos una entidad y la queremos convertir a fullDTO
    PersonaFullDto personaToPersonaFullDto(Persona persona);

    //recibimos un dto y la queremos convertir a una entidad persona
    Persona personaFullDtoToPersona(PersonaFullDto personaFullDto);

    //el shorDTO
    @Mapping(source = "domicilio.provincia", target = "provincia")
    PersonaShortDto personaToPersonaShortDto(Persona persona);

}
