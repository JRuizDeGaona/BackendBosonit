package com.formacion.Profesor.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;

public interface UpdateProfesorPort {
    ProfesorOutputDTO updatePorfesor (int id_profesor, ProfesorInputDTO profesorInputDTO) throws NotFoundException;
}
