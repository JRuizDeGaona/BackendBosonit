package com.formacion.Student.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.application.port.UpdateStudentPort;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {
    @Autowired
    StudentRepositorio studentRepositorio;

    /**
     * Método que me actualiza los cambios de los datos de un estudiante
     * @param id_student ID del estudiante que queremos actualizar
     * @param studentInputDTO Nuevos datos del estudiante
     * @return StuedntOutputDTO con los nuevos datos
     * @throws NotFoundException S i no encuentra el ID que le hemos pasado
     */
    @Override
    public StudentOutputDTO updateStudent(int id_student, StudentInputDTO studentInputDTO) throws NotFoundException {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID: "+id_student+" no encontrado"));
        student.update(studentInputDTO);

        studentRepositorio.saveAndFlush(student);
        return new StudentOutputDTO(student);
    }
}
