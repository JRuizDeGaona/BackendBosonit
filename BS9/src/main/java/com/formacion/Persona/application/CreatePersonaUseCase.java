package com.formacion.Persona.application;

import com.formacion.Persona.application.port.CreatePersonaPort;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        Persona persona = new Persona(personaInputDTO);
        PersonaOutputDTO personaOutput = new PersonaOutputDTO(persona);

        personaRepositorio.saveAndFlush(persona);
        return personaOutput;
    }
}
