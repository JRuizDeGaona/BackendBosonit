package com.formacion.Profesor.application.port;

import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;

public interface CreateProfesorPort {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;
}
