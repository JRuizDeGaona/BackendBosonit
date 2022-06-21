package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.ObtenerEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerEstudiosUseCase implements ObtenerEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;

    @Override
    public AlumnosEstudiosOutputDTO buscarPorId(int id_study, String outputType) throws NotFoundException {

        AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("ID no encontrado"));
        return elegirOpcion(id_study, outputType);
    }


    private AlumnosEstudiosOutputDTO elegirOpcion(int id_study, String outputType) {
        AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        if (outputType.equalsIgnoreCase("full")) {
            return fullDTO(alumnosEstudios);
        } else {
            return simpleDTO(alumnosEstudios);
        }
    }

    private AlumnosEstudiosOutputDTO fullDTO(AlumnosEstudios alumnos) {
        AlumnosEstudios alumnosEstudios = new AlumnosEstudios();

        alumnosEstudios.setStudent(alumnos.getStudent());
        alumnosEstudios.setProfesor(alumnos.getProfesor());
        alumnosEstudios.setId_study(alumnos.getId_study());
        alumnosEstudios.setAsignatura(alumnos.getAsignatura());
        alumnosEstudios.setComment(alumnos.getComment());
        alumnosEstudios.setFinish_date(alumnos.getFinish_date());
        alumnosEstudios.setInitial_date(alumnos.getInitial_date());

        return new AlumnosEstudiosOutputDTO(alumnosEstudios);
    }
    private AlumnosEstudiosOutputDTO simpleDTO(AlumnosEstudios alumnos) {
        AlumnosEstudios alumnosEstudios = new AlumnosEstudios();

        alumnosEstudios.setId_study(alumnos.getId_study());
        alumnosEstudios.setAsignatura(alumnos.getAsignatura());
        alumnosEstudios.setComment(alumnos.getComment());
        alumnosEstudios.setFinish_date(alumnos.getFinish_date());
        alumnosEstudios.setInitial_date(alumnos.getInitial_date());

        return new AlumnosEstudiosOutputDTO(alumnosEstudios);
    }


    @Override
    public List<AlumnosEstudiosOutputDTO> buscarTodos(String outputType) throws Exception {
        return elegirOpcionLista(outputType);
    }


    private List<AlumnosEstudiosOutputDTO> elegirOpcionLista(String outputType) {
        List<AlumnosEstudiosOutputDTO> alumnosEstudios = new ArrayList<>();

        if (outputType.equalsIgnoreCase("full")) {
            alumnosEstudiosRepositorio.findAll().forEach(alumnos -> alumnosEstudios.add(fullDTO(alumnos)));
        } else {
            alumnosEstudiosRepositorio.findAll().forEach(alumnos -> alumnosEstudios.add(simpleDTO(alumnos)));
        }

        return alumnosEstudios;
    }
}
