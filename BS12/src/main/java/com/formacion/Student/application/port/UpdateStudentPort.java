package com.formacion.Student.application.port;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;

public interface UpdateStudentPort {
    StudentOutputDTO updateStudent (int id_student, StudentInputDTO studentInputDTO) throws NotFoundException;
}
