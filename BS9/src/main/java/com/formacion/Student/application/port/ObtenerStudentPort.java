package com.formacion.Student.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;

import java.util.List;

public interface ObtenerStudentPort {
    StudentOutputDTO buscarPorId(int id_student, String outputType) throws NotFoundException;
    List<StudentOutputDTO> buscarTodos() throws Exception;
}