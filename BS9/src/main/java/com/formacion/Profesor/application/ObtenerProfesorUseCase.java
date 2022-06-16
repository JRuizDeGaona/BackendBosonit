package com.formacion.Profesor.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.application.port.ObtenerProfesorPort;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerProfesorUseCase implements ObtenerProfesorPort {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    /**
     * Método para buscar un profesor de la base de datos
     * @param id_profesor ID del profesor que queremos buscar
     * @param outputType Forma de mostrar los datos
     * @return ProfesorOutputDTO con los datos del profesor
     * @throws NotFoundException Si el ID pasado no existe
     */
    @Override
    public ProfesorOutputDTO buscarPorId(int id_profesor, String outputType) throws NotFoundException {
        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        return elegirOpcion(id_profesor, outputType);
    }

    /**
     * Método para mostrar la información del estudiante y su persona asociada
     * @param profesor Datos del estudiante
     * @return ProfesorOutputDTO con todos los datos del estudiante y la persona asociada
     */
    private ProfesorOutputDTO fullDTO(Profesor profesor) {
        Profesor profesorAux = new Profesor();

        profesorAux.setId_profesor(profesor.getId_profesor());
        profesorAux.setPersona(profesor.getPersona());
        profesorAux.setComents(profesor.getComents());
        profesorAux.setBranch(profesor.getBranch());

        return new ProfesorOutputDTO(profesorAux);
    }

    /**
     * Método privado para mostrar la información sólo del estudiante
     * @param profesor Datos del estudiante
     * @return StudentOutputDTO con sólo los datos del estudiante
     */
    private ProfesorOutputDTO simpleDTO(Profesor profesor) {
        Profesor profesorAux = new Profesor();

        profesorAux.setId_profesor(profesor.getId_profesor());
        profesorAux.setComents(profesor.getComents());
        profesorAux.setBranch(profesor.getBranch());

        return new ProfesorOutputDTO(profesorAux);
    }

    /**
     * Método privado que elige la opción a mostrar según el outputType
     * @param id_profesor ID del estudinate que queremos mostrar
     * @param outputType información que queremos mostrar
     * @return ProfesorOutputDTO simple o completo según el outputType
     */
    private ProfesorOutputDTO elegirOpcion(int id_profesor, String outputType) {
        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID: "+id_profesor+" no encontrado"));

        if (outputType.equalsIgnoreCase("full")) {
            return fullDTO(profesor);
        } else {
            return simpleDTO(profesor);
        }
    }

    /**
     * Método para buscar todos los profesores de la base de datos
     * @param outputType Forma de mostrar los datos (simple o full)
     * @return ProfesorOutputDTO con los datos de los profesores
     * @throws NotFoundException Si el ID pasado no existe
     */
    @Override
    public List<ProfesorOutputDTO> buscarTodos(String outputType) throws Exception {
        return elegirOpcionLista(outputType);
    }

    /**
     * Método que selecciona la forma de mostrar los datos de un profesor
     * @param outputType Forma de mostrar los datos (simple o full)
     * @return Lista con los profesores de la base de datos
     */
    private List<ProfesorOutputDTO> elegirOpcionLista(String outputType) {
        List<ProfesorOutputDTO> profesores = new ArrayList<>();

        if (outputType.equalsIgnoreCase("full")) {
            profesorRepositorio.findAll().forEach(profesor -> {
                profesores.add(fullDTO(profesor));
            });
        } else {
            profesorRepositorio.findAll().forEach(profesor -> {
                profesores.add(simpleDTO(profesor));
            });
        }
        return profesores;
    }
}
