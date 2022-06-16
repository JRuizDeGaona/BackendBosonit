package com.formacion.Persona.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;

import java.util.List;

public interface ObtenerPersonaPort {
    PersonaOutputDTO buscarPorId(int id_persona) throws NotFoundException;
    List<PersonaOutputDTO> buscarTodos() throws Exception;
    List<PersonaOutputDTO> buscarPorNombre(String nombre) throws Exception;
}
