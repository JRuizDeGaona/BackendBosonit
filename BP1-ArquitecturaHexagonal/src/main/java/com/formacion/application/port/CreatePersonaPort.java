package com.formacion.application.port;

import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;

public interface CreatePersonaPort {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
}
