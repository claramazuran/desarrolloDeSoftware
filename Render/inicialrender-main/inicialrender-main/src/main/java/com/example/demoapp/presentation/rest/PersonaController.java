package com.example.demoapp.presentation.rest;

import com.example.demoapp.business.facade.IPersonaFacade;
import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaFacade personaFacade;

    @GetMapping("/all/{id}")
    public ResponseEntity<PersonaFullDto> getAllDataById(@PathVariable Long id){
        return ResponseEntity.ok().body(personaFacade.getAllDataById(id));//ME COMUNICO CON EL PATRON FACHADA
    }

    @GetMapping("/short/{id}")
    public ResponseEntity<PersonaShortDto> getShortDataById(@PathVariable Long id){
        return ResponseEntity.ok().body(personaFacade.getShortDataById(id));
    }

    @PostMapping()
    public ResponseEntity<PersonaFullDto> crear(@RequestBody PersonaFullDto personaFullDto){//usamos un tipo de variable fullDto
        return ResponseEntity.ok().body(personaFacade.crear(personaFullDto));
    }

}
