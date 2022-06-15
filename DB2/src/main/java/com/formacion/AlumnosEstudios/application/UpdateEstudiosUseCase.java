package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.UpdateEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudiosUseCase implements UpdateEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public AlumnosEstudiosOutputDTO updateEstudios(int id_study, AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws NotFoundException {
        AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        alumnosEstudios.update(alumnosEstudiosInputDTO);
        alumnosEstudios.setProfesor(getIdProfesor(alumnosEstudiosInputDTO));
        alumnosEstudios.setStudent(getIdStudent(alumnosEstudiosInputDTO));

        alumnosEstudiosRepositorio.saveAndFlush(alumnosEstudios);
        return new AlumnosEstudiosOutputDTO(alumnosEstudios);
    }

    private Profesor getIdProfesor(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) {
        int id_profesor = alumnosEstudiosInputDTO.getId_profesor();

        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID de profesor no encontrado"));
        return profesor;
    }

    private Student getIdStudent(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) {
        int id_student = alumnosEstudiosInputDTO.getId_student();

        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID de estudiante no encontrado"));
        return student;
    }
}
