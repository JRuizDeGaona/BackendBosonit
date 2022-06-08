package com.formacion.Profesor.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.application.port.UpdateProfesorPort;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUseCase implements UpdateProfesorPort {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
    public ProfesorOutputDTO updatePorfesor(int id_profesor, ProfesorInputDTO profesorInputDTO) throws NotFoundException {
        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID no encontrado"));
        profesor.update(profesorInputDTO);

        profesorRepositorio.saveAndFlush(profesor);
        return new ProfesorOutputDTO(profesor);
    }
}
