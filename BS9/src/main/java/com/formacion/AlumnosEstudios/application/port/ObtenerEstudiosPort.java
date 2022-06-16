package com.formacion.AlumnosEstudios.application.port;

import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.Excepciones.NotFoundException;

import java.util.List;

public interface ObtenerEstudiosPort {
    AlumnosEstudiosOutputDTO buscarPorId (int id_study, String outputType) throws NotFoundException;
    List<AlumnosEstudiosOutputDTO> buscarTodos(String outputType) throws Exception;
}
