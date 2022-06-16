package com.formacion.Student.application.port;

import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;

public interface CreateStudentPort {
    StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) throws Exception;
}
