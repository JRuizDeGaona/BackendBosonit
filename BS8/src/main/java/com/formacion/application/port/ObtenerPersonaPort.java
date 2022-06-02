package com.formacion.application.port;

import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.exception.NotFoundException;

import java.util.List;

public interface ObtenerPersonaPort {
    PersonaOutputDTO buscarPorId (int id_persona) throws NotFoundException;
    List<PersonaOutputDTO> buscarPorNombre (String nombre) throws Exception;
    List<PersonaOutputDTO> buscarTodos() throws Exception;
}
