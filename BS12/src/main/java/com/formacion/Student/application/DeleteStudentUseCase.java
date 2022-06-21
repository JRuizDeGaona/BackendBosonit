package com.formacion.Student.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.application.port.DeleteStudentPort;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase implements DeleteStudentPort {
    @Autowired
    StudentRepositorio studentRepositorio;

    /**
     * Método que elimina un estudiante de la base de datos
     * @param id_student ID del estudiante que queremos eliminar
     * @throws NotFoundException Si el ID no existe
     */
    @Override
    public void deleteStudent(int id_student) throws NotFoundException {
        Student student;
        student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID: "+id_student+" no encontrado"));

        studentRepositorio.deleteById(id_student);
    }
}
