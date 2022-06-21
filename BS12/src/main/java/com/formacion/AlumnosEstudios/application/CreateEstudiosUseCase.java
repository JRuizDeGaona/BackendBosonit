package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.CreateEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateEstudiosUseCase implements CreateEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public AlumnosEstudiosOutputDTO addEstudios(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws Exception {
        AlumnosEstudios alumnosEstudios = new AlumnosEstudios(alumnosEstudiosInputDTO);
        alumnosEstudios.setProfesor(getProfesor(alumnosEstudiosInputDTO));
        alumnosEstudios.setStudent(getStudent(alumnosEstudiosInputDTO));

        if (alumnosEstudiosInputDTO == null) {
            throw new UnprocessableEntityException("No se pueden meter estudios sin datos");
        } else {
            alumnosEstudiosRepositorio.saveAndFlush(alumnosEstudios);
            System.out.println("Estudios guardados");
        }
        asignarEstudios(alumnosEstudios);
        return new AlumnosEstudiosOutputDTO(alumnosEstudios);
    }

    private Profesor getProfesor(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) {
        int id_profesor = alumnosEstudiosInputDTO.getId_profesor();
        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        return profesor;
    }
    private Student getStudent(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) {
        int id_student = alumnosEstudiosInputDTO.getId_student();
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        return student;
    }

    private List<AlumnosEstudios> asignarEstudios(AlumnosEstudios alumnosEstudios) {
        List<AlumnosEstudios> listaAsignaturas = new ArrayList<>();

        studentRepositorio.findAll().forEach(student -> {
            if (alumnosEstudios.getStudent().getId_student() == student.getId_student()) {
                student.getEstudios().add(alumnosEstudios);
                studentRepositorio.saveAndFlush(student);
            }
        });

        return listaAsignaturas;
    }
}
