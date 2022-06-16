package com.formacion.Profesor.infraestructure.controller;

import com.formacion.Profesor.application.port.CreateProfesorPort;
import com.formacion.Profesor.application.port.DeleteProfesorPort;
import com.formacion.Profesor.application.port.ObtenerProfesorPort;
import com.formacion.Profesor.application.port.UpdateProfesorPort;
import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import com.formacion.Excepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ControladorProfesor {
    @Autowired
    CreateProfesorPort createProfesorPort;
    @Autowired
    DeleteProfesorPort deleteProfesor;
    @Autowired
    UpdateProfesorPort updateProfesorPort;
    @Autowired
    ObtenerProfesorPort obtenerProfesorPort;

    /**
     * Método para buscar un profesor de la base de datos
     * @param id_profesor ID del profesor que queremos buscar
     * @param outputType Forma de mostrar los datos
     * @return ProfesorOutputDTO con los datos del profesor
     * @throws NotFoundException Si el ID pasado no existe
     */
    @GetMapping("/buscarId/{id_profesor}")
    public ProfesorOutputDTO buscarId(@PathVariable int id_profesor, @RequestParam (name = "outputType", defaultValue = "simple")String outputType) throws NotFoundException{
        return obtenerProfesorPort.buscarPorId(id_profesor, outputType);
    }

    /**
     * Método para buscar todos los profesores de la base de datos
     * @param outputType Forma de mostrar los datos (simple o full)
     * @return ProfesorOutputDTO con los datos de los profesores
     * @throws NotFoundException Si el ID pasado no existe
     */
    @GetMapping("/showAll")
    public List<ProfesorOutputDTO> mostrarTodo(@RequestParam (name = "outputType", defaultValue = "simple")String outputType) throws Exception {
        return obtenerProfesorPort.buscarTodos(outputType);
    }

    /**
     * Método para añadir profesor a la base de datos
     * @param profesorInputDTO Datos del profesor a añadir
     * @return El profesor añadido
     * @throws Exception Si el profesor a añadir no tiene datos
     */
    @PostMapping("/addProfesor")
    public ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return createProfesorPort.addProfesor(profesorInputDTO);
    }

    /**
     * Método que elimina un profesor de la base de datos
     * @param id_profesor ID del profesor que queremos eliminar
     * @throws NotFoundException si el ID introducido no existe
     */
    @DeleteMapping("/deleteProfesor/{id_profesor}")
    public void deleteProfesor(@PathVariable int id_profesor) throws NotFoundException{
        deleteProfesor.deletePorfesor(id_profesor);
    }

    /**
     * Método que actualiza los datos de un profesor de la base de datos
     * @param id_profesor ID del profesor que queremos modificar
     * @param profesorInputDTO Datos a cambiar del profesor
     * @return El profesor con sus nuevos datos
     * @throws NotFoundException Si el ID pasado no existe
     */
    @PutMapping("/update/{id_profesor}")
    public ProfesorOutputDTO updateProfesor(@PathVariable int id_profesor, @RequestBody ProfesorInputDTO profesorInputDTO) throws NotFoundException {
        return updateProfesorPort.updatePorfesor(id_profesor, profesorInputDTO);
    }
}