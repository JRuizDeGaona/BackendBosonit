package com.formacion.Student.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.application.port.ObtenerStudentPort;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerStudentUseCase implements ObtenerStudentPort {
    @Autowired
    StudentRepositorio studentRepositorio;

    /**
     * Método que muestra una persona según su ID
     * @param id_student ID del estudiante que queremos ver la información
     * @param outputType Si queremos ver la información sólo del estudiante ("simple") o también de la persona asociada ("full")
     * @return StudentOutputDTO con los datos del estudiante
     * @throws NotFoundException Si no encunetra el ID que le hemos pasado
     */
    @Override
    public StudentOutputDTO buscarPorId(int id_student, String outputType) throws NotFoundException {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID: "+id_student+" no encontrado"));

        return elegirOpcion(id_student,outputType);
    }

    /**
     * Método para mostrar la información del estudiante y su persona asociada
     * @param student Datos del estudiante
     * @return StudentOutputDTO con todos los datos del estudiante y la persona asociada
     */
    private StudentOutputDTO fullDTO(Student student) {
        Student studentAux = new Student();

        studentAux.setId_student(student.getId_student());
        studentAux.setPersona(student.getPersona());
        studentAux.setNum_hours_week(student.getNum_hours_week());
        studentAux.setComents(student.getComents());
        studentAux.setProfesor(student.getProfesor());
        studentAux.setBranch(student.getBranch());

        return new StudentOutputDTO(studentAux);
    }

    /**
     * Método privado para mostrar la información sólo del estudiante
     * @param student Datos del estudiante
     * @return StudentOutputDTO con sólo los datos del estudiante
     */
    private StudentOutputDTO simpleDTO(Student student) {
        Student studentAux = new Student();

        studentAux.setId_student(student.getId_student());
        studentAux.setNum_hours_week(student.getNum_hours_week());
        studentAux.setComents(student.getComents());
        studentAux.setBranch(student.getBranch());

        return new StudentOutputDTO(studentAux);
    }

    /**
     * Método privado que elige la opción a mostrar según el outputType
     * @param id_student ID del estudinate que queremos mostrar
     * @param outputType información que queremos mostrar
     * @return StudentOutputDTO simple o completo según el outputType
     */
    private StudentOutputDTO elegirOpcion(int id_student, String outputType) {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID: "+id_student+" no encontrado"));

        if (outputType.equalsIgnoreCase("full")) {
            return fullDTO(student);
        } else {
            return simpleDTO(student);
        }
    }

    /**
     * Método que te devuelve una lsita con todos los estudiantes de la base de datos
     * @return Lista de los estudiantes
     * @throws Exception Si la lista está vacía
     */
    @Override
    public List<StudentOutputDTO> buscarTodos() throws Exception {
        List<StudentOutputDTO> students = new ArrayList<>();

        studentRepositorio.findAll().forEach(student -> {
            StudentOutputDTO studentOutputDTO= new StudentOutputDTO(student);
            students.add(studentOutputDTO);
        });

        if (students.isEmpty()) {
            throw new Exception("No se han encontrado estudiantes en la base de datos");
        }
        return students;
    }
}
