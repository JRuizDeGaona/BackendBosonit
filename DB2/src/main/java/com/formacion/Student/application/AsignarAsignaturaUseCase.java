package com.formacion.Student.application;

import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.application.port.AsignarAsignaturaPort;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AsignarAsignaturaUseCase implements AsignarAsignaturaPort {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;
    @Override
    public Student asignarAsigantura(int id_student, Map<String, Integer> id_study) {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID de estudiante no encontrado"));

        for (Integer id : id_study.values()) {
            AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id).orElseThrow(() -> new NotFoundException("ID de asignatura no encontrado"));
            student.getEstudios().add(alumnosEstudios);
            studentRepositorio.saveAndFlush(student);
        }

        return student;
    }

    @Override
    public Student desasignarAsignatura(int id_student, Map<String, Integer> id_study) {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID de estudiante no encontrado"));

        for (Integer id: id_study.values()) {
            AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id).orElseThrow(() -> new NotFoundException("ID de asignatura no encontrado"));
            student.getEstudios().remove(alumnosEstudios);
            studentRepositorio.saveAndFlush(student);
        }
        return student;
    }
}
