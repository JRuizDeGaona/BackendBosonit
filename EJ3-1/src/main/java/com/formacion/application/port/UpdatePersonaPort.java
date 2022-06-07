package com.formacion.application.port;

import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.exception.NotFoundException;

public interface UpdatePersonaPort {
    PersonaOutputDTO updatePersona (int id_persona, PersonaInputDTO personaInputDTO) throws NotFoundException;
}
