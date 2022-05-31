package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PersonaService {
    @Autowired
    PersonaRepositorio personaRepositorio;

    public Persona addPersona(Persona persona) throws Exception {
        if (persona.getUsuario().length()<6 || persona.getUsuario().length() > 10) {
            throw new Exception("La longitud del nombre de usuario debe estar entre 6 y 10 caracteres");
        }
        personaRepositorio.save(persona);
        return persona;
    }

    public void deletePersona(int id) throws Exception{
        PersonaDTO persona;
        persona = buscarPorID(id);

        if(persona == null){
            System.out.println("No hay usuarios");
        }else{
            personaRepositorio.deleteById(id);
        }
    }

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

    public PersonaDTO buscarPorID(int personaId) throws Exception {
        Persona persona;
        PersonaDTO personaDTO;

        persona = personaRepositorio.findById(personaId).orElseThrow(() -> new Exception("ID no encontrado"));
        personaDTO = new PersonaDTO(persona);

        return personaDTO;
    }

    public List<PersonaDTO> buscarPorUsuario(String nombreUsu) {
        List<PersonaDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            if (persona.getUsuario().equalsIgnoreCase(nombreUsu)) {
                PersonaDTO personaDTO = new PersonaDTO(persona);
                listaPersonas.add(personaDTO);
            }
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("Sin usuarios con ese nombre");
        }
        return listaPersonas;
    }

    public List<PersonaDTO> buscarTodos() {
        List<PersonaDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            PersonaDTO personaDTO = new PersonaDTO(persona);
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }

}
