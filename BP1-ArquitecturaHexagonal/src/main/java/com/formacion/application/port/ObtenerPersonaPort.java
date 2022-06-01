package com.formacion.application.port;

import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import java.util.List;

public interface ObtenerPersonaPort {
    PersonaOutputDTO buscarPorId (int id_persona) throws Exception;
    List<PersonaOutputDTO> buscarPorNombre (String nombre) throws Exception;
    List<PersonaOutputDTO> buscarTodos() throws Exception;
}
