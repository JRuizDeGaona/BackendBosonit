package com.formacion.application.useCase;

import com.formacion.application.port.CreatePersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.exception.UnprocesableException;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO addPersona(@Valid PersonaInputDTO personaInputDTO) throws UnprocesableException {
        EntityPersona persona = new EntityPersona(personaInputDTO);
        PersonaOutputDTO personaOutput = new PersonaOutputDTO(persona);

        personaRepository.saveAndFlush(persona);
        return personaOutput;
    }
}
