package com.formacion.Student.application.port;

import com.formacion.Excepciones.NotFoundException;

public interface DeleteStudentPort {
    void deleteStudent (int id_student) throws NotFoundException;
}
