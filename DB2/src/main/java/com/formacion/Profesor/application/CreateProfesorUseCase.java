package com.formacion.Profesor.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import com.formacion.Profesor.application.port.CreateProfesorPort;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfesorUseCase implements CreateProfesorPort {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    PersonaRepositorio personaRepositorio;

    /**
     * Método para añadir profesor a la base de datos
     * @param profesorInputDTO Datos del profesor a añadir
     * @return El profesor añadido
     * @throws Exception Si el profesor a añadir no tiene datos
     */
    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Profesor profesor = new Profesor(profesorInputDTO);
        profesor.setPersona(getPersona(profesorInputDTO));

        if (profesorInputDTO == null) {
            throw new UnprocessableEntityException("No se puede introducir un estudiante sin datos");
        } else {
            profesorRepositorio.saveAndFlush(profesor);
            System.out.println("Profesor guardado");
        }

        return new ProfesorOutputDTO(profesor);
    }

    private Persona getPersona(ProfesorInputDTO profesorInputDTO) {
        int id_persona = profesorInputDTO.getId_persona();
        Persona persona = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        return persona;
    }
}
