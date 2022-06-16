package com.formacion.Profesor.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;

import java.util.List;

public interface ObtenerProfesorPort {
    ProfesorOutputDTO buscarPorId(int id_profesor, String outputType) throws NotFoundException;
    List<ProfesorOutputDTO> buscarTodos(String outputType) throws Exception;
}
