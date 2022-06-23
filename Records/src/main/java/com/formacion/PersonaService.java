package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonaRepositorio personaRepositorio;

    /**
     * Método que añade una persona a la base de datos
     * @param personaDTO Datos de la persona que queremos añadir
     * @return Persona ya añadida a la base de datos
     * @throws Exception Si no cumple con la restricción de nombre de usuario (length > 6 AND length < 10)
     */
    public PersonaDTO addPersona(PersonaDTO personaDTO) throws Exception {
        Persona persona = new Persona();
        if (personaDTO.usuario().length() < 6 || personaDTO.usuario().length() > 10) {
            throw new Exception("La longitud del nombre de usuario debe estar entre 6 y 10 caracteres");
        }
        persona.setId_persona(personaDTO.id_persona());
        persona.setUsuario(personaDTO.usuario());
        persona.setImagen_url(personaDTO.imagen_url());
        persona.setTermination_date(personaDTO.termination_date());
        persona.setCreated_date(personaDTO.termination_date());
        persona.setActive(personaDTO.active());
        persona.setCity(personaDTO.city());
        persona.setPersonal_email(personaDTO.personal_email());
        persona.setSurname(personaDTO.surname());
        persona.setPassword(personaDTO.password());
        persona.setCompany_email(personaDTO.company_email());

        personaRepositorio.save(persona);
        return personaDTO;
    }

    /**
     * Método que borra una persona de la base de datos
     * @param id ID de la persona que queremos borrar
     * @throws Exception Si el ID de la persona pasada no existe
     */
    public void deletePersona(int id) throws Exception{
        Persona persona = buscarPorID(id);

        if(persona == null){
            System.out.println("No hay usuarios");
        }else{
            personaRepositorio.deleteById(id);
        }
    }

    /**
     * Método que actualiza los datos de una persona
     * @param id ID de la persona que queremos actualizar los datos
     * @param p Persona con los datos que queremos cambiar
     */
    public void updatePersona(int id, Persona p) {
        personaRepositorio.findAll().forEach(persona -> {
            if (persona.getId_persona() == id) {
                persona.setId_persona(p.getId_persona());
                persona.setName(p.getName());
                persona.setSurname(p.getSurname());
                persona.setUsuario(p.getUsuario());
                persona.setPassword(p.getPassword());
                persona.setPersonal_email(p.getPersonal_email());
                persona.setCompany_email(p.getCompany_email());
                persona.setCity(p.getCity());
                persona.setImagen_url(p.getImagen_url());
                persona.setCreated_date(p.getCreated_date());
                persona.setTermination_date(p.getTermination_date());
                persona.setActive(p.isActive());

                personaRepositorio.saveAndFlush(persona);
            }
        });
    }

    /**
     * Método para buscar por ID un usuario
     * @param personaId ID de la persona que queremos buscar
     * @return Objeto de tipo Persona con sus datos
     * @throws Exception Si el ID no se encuentra
     */
    public Persona buscarPorID(int personaId) throws Exception {
        return personaRepositorio.findById(personaId).orElseThrow(() -> new Exception("ID no encontrado"));
    }

    /**
     * Método para buscar una persona por su nombre de usuario
     * @param nombreUsu nombre de usuario de la persona que queremos buscar
     * @return Lista de personas con ese nombre de usuario
     */
    public List<PersonaDTO> buscarPorUsuario(String nombreUsu) {
        List<PersonaDTO> listaPersonas = new ArrayList<>();
        List<Persona> listAux = personaRepositorio.findByUsuario(nombreUsu);

        listAux.forEach(persona -> {
            PersonaDTO personaDTO = new PersonaDTO(persona.getId_persona(), persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(), persona.getCity(), persona.isActive(),persona.getCreated_date(), persona.getImagen_url(), persona.getTermination_date());
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("Sin usuarios con ese nombre");
        }
        return listaPersonas;
    }

    /**
     * Método que lista todas las personas de la base de datos
     * @return Lista de personas de la base de datos
     */
    public List<PersonaDTO> buscarTodos() {
        List<PersonaDTO> listaPersonas = new ArrayList<>();
        List<Persona> listAux = personaRepositorio.findAll();

        listAux.forEach(persona -> {
            PersonaDTO personaDTO = new PersonaDTO(persona.getId_persona(), persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(), persona.getCity(), persona.isActive(), persona.getCreated_date(), persona.getImagen_url(),  persona.getTermination_date());
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }

}
