package com.formacion.Persona.application.port;

import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;

public interface CreatePersonaPort {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
}
