package com.formacion.Persona.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;

public interface UpdatePersonaPort {
    PersonaOutputDTO updatePersona (int id_persona, PersonaInputDTO personaInputDTO) throws NotFoundException;
}
