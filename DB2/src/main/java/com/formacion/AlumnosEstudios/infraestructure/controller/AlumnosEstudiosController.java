package com.formacion.AlumnosEstudios.infraestructure.controller;

import com.formacion.AlumnosEstudios.application.port.CreateEstudiosPort;
import com.formacion.AlumnosEstudios.application.port.DeleteEstudiosPort;
import com.formacion.AlumnosEstudios.application.port.ObtenerEstudiosPort;
import com.formacion.AlumnosEstudios.application.port.UpdateEstudiosPort;
import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estudios")
public class AlumnosEstudiosController {
    @Autowired
    CreateEstudiosPort createEstudiosPort;
    @Autowired
    DeleteEstudiosPort deleteEstudiosPort;
    @Autowired
    UpdateEstudiosPort updateEstudiosPort;
    @Autowired
    ObtenerEstudiosPort obtenerEstudiosPort;

    /**
     * Método para añadir asignaturas a la base de datos
     * @param alumnosEstudiosInputDTO Datos de la asignatura que queremos añadir
     * @return Información de la asignatura añadida
     * @throws Exception Si se mete una asignatura sin datos
     */
    @PostMapping("/addEstudios")
    public AlumnosEstudiosOutputDTO addEstudios(@RequestBody AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws Exception {
        return createEstudiosPort.addEstudios(alumnosEstudiosInputDTO);
    }

    /**
     * Método que borra un estudio de la base de datos
     * @param id_study ID del estudio que queremos borrar
     */
    @DeleteMapping("/deleteEstudios/{id_study}")
    public void deleteEstudios(@PathVariable int id_study) {
        deleteEstudiosPort.deleteEstudios(id_study);
    }

    /**
     * Método que actualiza la información de unos estudios
     * @param alumnosEstudiosInputDTO Información que queremos modificar
     * @param id_study ID de los estudios que queremos modificar
     * @return La información de los estudios ya modificados
     */
    @PutMapping("/updateEstudios/{id_study}")
    public AlumnosEstudiosOutputDTO updateEstudios(@RequestBody AlumnosEstudiosInputDTO alumnosEstudiosInputDTO, @PathVariable int id_study) {
        return updateEstudiosPort.updateEstudios(id_study, alumnosEstudiosInputDTO);
    }

    /**
     * Método que devuelve un estudio según su ID
     * @param id_study ID del estudio que queremos buscar
     * @param outputType (full o simple) que indica la información que queremos mostrar
     * @return El estudio con el ID que hemos especificado
     */
    @GetMapping("/buscar/{id_study}")
    public AlumnosEstudiosOutputDTO buscarPorId (@PathVariable int id_study, @RequestParam String outputType) {
        return obtenerEstudiosPort.buscarPorId(id_study, outputType);
    }

    /**
     * Método que devuelve una Lista con todos los estudios de la base de datos
     * @param outputType String (full o simple) que indica la información que queremos mostrar
     * @return Lista con todas las asignaturas
     * @throws Exception Si ocurre algun error en la ejecución o se mete algún ID no válido
     */
    @GetMapping("/buscarTodos")
    public List<AlumnosEstudiosOutputDTO> buscarTodos (@RequestParam String outputType) throws Exception {
        return obtenerEstudiosPort.buscarTodos(outputType);
    }
}
