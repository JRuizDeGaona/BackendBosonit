package com.formacion.Persona.infraestructure.controller;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Persona.application.port.CreatePersonaPort;
import com.formacion.Persona.application.port.DeletePersonaPort;
import com.formacion.Persona.application.port.ObtenerPersonaPort;
import com.formacion.Persona.application.port.UpdatePersonaPort;
import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {
    @Autowired
    CreatePersonaPort createPersonaPort;
    @Autowired
    UpdatePersonaPort updatePersonaPort;
    @Autowired
    DeletePersonaPort deletePersonaPort;
    @Autowired
    ObtenerPersonaPort obtenerPersonaPort;


    // MOSTRAR LAS PERSONAS DE LA BASE DE DATOS
    /**
     * Métoto que busca un usuario de la base de datos
     * @param id_persona ID de la persona que queremos buscar en la base de datos
     * @return Persona con el ID que hemos pasado
     * @throws Exception Si no está el ID que hemos especificado
     */
    @GetMapping("/buscarId/{id_persona}")
    public PersonaOutputDTO buscarPorId (@PathVariable int id_persona) throws NotFoundException {
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
        checkPersona(personaInputDTO);
        PersonaOutputDTO personaOutputDTO = createPersonaPort.addPersona(personaInputDTO);

        return personaOutputDTO;
    }

    /**
     * Método para eliminar personas de la base de datos
     * @param id_persona ID de la persona que queremos eliminar
     * @throws Exception Si el ID pasado no existe
     */
    @DeleteMapping("/deletePersona/{id_persona}")
    public void deletePersona (@PathVariable int id_persona) throws NotFoundException {
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
    public PersonaOutputDTO updatePersona (@PathVariable int id_persona, @RequestBody PersonaInputDTO personaInputDTO) throws NotFoundException {
        checkPersona(personaInputDTO);
        return updatePersonaPort.updatePersona(id_persona, personaInputDTO);
    }

    @GetMapping("/{id}")
    public ProfesorOutputDTO getProfesor (@PathVariable int id) {
        ResponseEntity<ProfesorOutputDTO> profesor;
        profesor = new RestTemplate().getForEntity("http://localhost:8081/profesor/buscarId/" + id, ProfesorOutputDTO.class);

        if (profesor.getStatusCode() == HttpStatus.OK) {
            return profesor.getBody();
        } else {
            throw new RuntimeException("Error en el servidor");
        }
    }

    /**
     * Método que nos permite comprobar todas las restricciones a la hora de meter usuarios en la base de datos
     * @param personaInputDTO PersonaInputDTO con los datos de la persona que quermeos introducir
     */
    private void checkPersona(PersonaInputDTO personaInputDTO){
        if(personaInputDTO == null){
            throw new UnprocessableEntityException("No se puede introducir una persona sin información");
        }
        if (personaInputDTO.getUsuario() == null || personaInputDTO.getUsuario().isBlank()) {
            throw new UnprocessableEntityException("El campo Usuario no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("El campo Usuario debe tener como máximo 10 caracteres de longitud");
        }
        if (personaInputDTO.getUsuario().length() < 6) {
            throw new UnprocessableEntityException("El campo Usuario debe tener como mínimo 6 caracteres de longitud");
        }
        if (personaInputDTO.getPassword() == null || personaInputDTO.getPassword().isBlank()) {
            throw new UnprocessableEntityException("El campo Password no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getName() == null || personaInputDTO.getName().isBlank()) {
            throw new UnprocessableEntityException("El campo nombre no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCompany_email() == null || personaInputDTO.getCompany_email().isBlank()) {
            throw new UnprocessableEntityException("El campo Company_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getPersonal_email() == null || personaInputDTO.getPersonal_email().isBlank()) {
            throw new UnprocessableEntityException("El campo Personal_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCity() == null || personaInputDTO.getCity().isBlank()) {
            throw new UnprocessableEntityException("El campo Ciudad no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCreated_date() == null) {
            throw new UnprocessableEntityException("El campo Created-Date no puede ser nulo ni estar vacío");
        }
    }
}
