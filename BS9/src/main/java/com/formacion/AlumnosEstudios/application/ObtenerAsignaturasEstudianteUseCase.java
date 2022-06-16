package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.ObtenerAsignaturasEstudiantePort;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.Excepciones.NotFoundException;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerAsignaturasEstudianteUseCase implements ObtenerAsignaturasEstudiantePort {
    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public List obtenerAsignaturas(int id_student) {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID de estudiante no encontrado"));

        List listaEstudios =student.getEstudios();

        return listaEstudios;
    }
}
