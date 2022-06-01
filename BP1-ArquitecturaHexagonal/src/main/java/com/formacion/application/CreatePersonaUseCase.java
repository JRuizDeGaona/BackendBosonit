package com.formacion.application;

import com.formacion.application.port.CreatePersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        EntityPersona persona = new EntityPersona(personaInputDTO);
        PersonaOutputDTO personaOutput = new PersonaOutputDTO(persona);

        if (persona == null) {
            throw new Exception("Persona Sin datos");
        }
        personaRepository.saveAndFlush(persona);
        return personaOutput;
    }
}
