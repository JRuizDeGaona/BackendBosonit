package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    /**
     * Método que añade una persona a nuestra base de datos
     * @param persona Persona que queremos añadir
     * @return Persona que hemos añadido
     * @throws Exception Por si no cumple las reglas del nombre del usuario
     */
    @PostMapping("/addPersona")
    public Persona addPersona(@RequestBody Persona persona) throws Exception{
       return personaService.addPersona(persona);
    }

    /**
     * Elimina una Persona según el id pasado
     * @param id ID de la Persona que queremos eliminar
     * @throws Exception Si el ID pasado no existe
     */
    @DeleteMapping("/eliminarPersona/{id}")
    public void deletePersona (@PathVariable int id) throws Exception{
        personaService.deletePersona(id);
        System.out.println("Usuario con id: "+id+" eliminado");
    }

    /**
     * Método para actualizar los datos de una persona, el id debe ser el mismo
     * @param id ID de la persona que queremos modificar
     * @param p Nuevos datos de la persona
     */
    @PutMapping("/updatePersona/{id}")
    public void updatePersona(@PathVariable int id, @RequestBody Persona p) {
        personaService.updatePersona(id, p);
    }


    /**
     * Método que busca la persona cuyo id es pasado por el usuario
     * @param id ID de la persona que queremos buscar
     * @return La persona que queremos buscar
     * @throws Exception ID no encontrado
     */
    @GetMapping("/buscarPorID/{id}")
    public PersonaDTO buscarPorId(@PathVariable int id) throws Exception{
        return personaService.buscarPorID(id);
    }

    /**
     * Método que busca una Persona por su nombre de usuario
     * @param nombreUsu Nombre de usuario de la persona que queremos buscar
     * @return Lista con todas las personas con ese nombre
     */
    @GetMapping("/buscarPorNombre/{nombreUsu}")
    public List<PersonaDTO> buscarPorNombre(@PathVariable String nombreUsu) {
        return personaService.buscarPorUsuario(nombreUsu);
    }

    /**
     * Método que muestra todas las Personas de la Base de datos
     * @return Una Lista con las personas de la Base de datos
     */
    @GetMapping("/buscarTodos")
    public List<PersonaDTO> buscarTodos() {
        return personaService.buscarTodos();
    }
}
