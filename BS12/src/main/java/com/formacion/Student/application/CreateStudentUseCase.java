package com.formacion.Student.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import com.formacion.Student.application.port.CreateStudentPort;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentUseCase implements CreateStudentPort {
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;

    /**
     * Método para añadir un estudiante en la base de datos
     * @param studentInputDTO Datos de estudiante a añadir
     * @return StudentOutputDTO con los datos del estudiante
     * @throws Exception Si el estudiante no tiene datos
     */
    @Override
    public StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) throws Exception {
        Student student = new Student(studentInputDTO);
        student.setPersona(getPersona(studentInputDTO));

        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(student);

        if(studentInputDTO == null){
            throw new UnprocessableEntityException("No se puede introducir un estudiante sin datos");
        }else{
            studentRepositorio.saveAndFlush(student);
            System.out.println("Estudiante guardado");
        }
        return studentOutputDTO;
    }

    /**
     * Método que obitene la persona que corresponde al id_persona del estudiante
     * @param studentInputDTO Datos del estudiante
     * @return Persona que corresponde ese estudiante
     */
    private Persona getPersona(StudentInputDTO studentInputDTO) {
        int id_persona = studentInputDTO.getId_persona();
        Persona persona = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("ID INVÁLIDO"));

        return persona;
    }
}
