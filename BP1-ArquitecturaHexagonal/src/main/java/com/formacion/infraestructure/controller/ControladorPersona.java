package com.formacion.infraestructure.controller;

import com.formacion.application.port.CreatePersonaPort;
import com.formacion.application.port.DeletePersonaPort;
import com.formacion.application.port.ObtenerPersonaPort;
import com.formacion.application.port.UpdatePersonaPort;
import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {
    @Autowired
    DeletePersonaPort deletePersonaPort;
    @Autowired
    UpdatePersonaPort updatePersonaPort;
    @Autowired
    ObtenerPersonaPort obtenerPersonaPort;
    @Autowired
    CreatePersonaPort createPersonaPort;


    // MOSTRAR LAS PERSONAS EN LA BASE DE DATOS
    /**
     * Métoto que busca un usuario de la base de datos
     * @param id_persona ID de la persona que queremos buscar en la base de datos
     * @return Persona con el ID que hemos pasado
     * @throws Exception Si no está el ID que hemos especificado
     */
    @GetMapping("/buscarId/{id_persona}")
    public PersonaOutputDTO buscarPorId (@PathVariable int id_persona) throws Exception {
        return obtenerPersonaPort.buscarPorId(id_persona);
    }

    /**
     * Métoto que busca uno o varios usuarios de la base de datos
     * @param nombre Nombre de usuario de la persona que queremos buscar en la base de datos
     * @return Lista con todas las personas con ese nombre de Usuario
     * @throws Exception Si el nombre de usuario no existe
     */
    @GetMapping("/buscarNombre/{nombre}")
    public List<PersonaOutputDTO> buscarPorNombre (@PathVariable String nombre) throws Exception {
       return obtenerPersonaPort.buscarPorNombre(nombre);
    }

    /**
     * Método que muestra los datos de todas las personas de la base de datos
     * @return Lista con los datos de todas las personas
     * @throws Exception Si falla algo en la peticion
     */
    @GetMapping("/buscarTodos")
    public List<PersonaOutputDTO> buscarTodos () throws Exception {
        return obtenerPersonaPort.buscarTodos();
    }


    // MÉTODOS DEL CRUD
    /**
     * Método para añadir personas a la base de datos
     * @param personaInputDTO Persona que queremos añadir
     * @return Persona que hemos añadido
     * @throws Exception Si no cumple el formato correcto de los datos
     */
    @PostMapping("/addPersona")
    public PersonaOutputDTO addPersona (@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return createPersonaPort.addPersona(personaInputDTO);
    }

    /**
     * Método para eliminar personas de la base de datos
     * @param id_persona ID de la persona que queremos eliminar
     * @throws Exception Si el ID pasado no existe
     */
    @DeleteMapping("/deletePersona/{id_persona}")
    public void deletePersona (@PathVariable int id_persona) throws Exception {
        deletePersonaPort.deletePersona(id_persona);
    }

    /**
     * Método para modificar la información de un usuario
     * @param id_persona ID de la persona que queremos eliminar
     * @param personaInputDTO Datos modificados de la persona
     * @return Persona con los datos ya modificados
     * @throws Exception Si el ID de la persona que hemos pasado no existe
     */
    @PutMapping("/updatePersona/{id_persona}")
    public PersonaOutputDTO updatePersona (@PathVariable int id_persona, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return updatePersonaPort.updatePersona(id_persona, personaInputDTO);
    }
}
