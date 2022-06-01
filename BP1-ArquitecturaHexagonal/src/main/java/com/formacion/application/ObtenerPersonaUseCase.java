package com.formacion.application;

import com.formacion.application.port.ObtenerPersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPersonaUseCase implements ObtenerPersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO buscarPorId(int id_persona) throws Exception {
        EntityPersona persona;
        PersonaOutputDTO personaDTO;

        persona = personaRepository.findById(id_persona).orElseThrow(() -> new Exception("No existe el ID"));//404
        personaDTO = new PersonaOutputDTO(persona);

        return personaDTO;
    }

    @Override
    public List<PersonaOutputDTO> buscarPorNombre(String nombre) throws Exception {
        List<PersonaOutputDTO> listaPersonas = new ArrayList<>();

        personaRepository.findAll().forEach(persona -> {
            if (persona.getUsuario().equalsIgnoreCase(nombre)) {
                PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
                listaPersonas.add(personaDTO);
            }
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("Sin usuarios con ese nombre");
        }
        return listaPersonas;
    }

    @Override
    public List<PersonaOutputDTO> buscarTodos() throws Exception {
        List<PersonaOutputDTO> listaPersonas = new ArrayList<>();

        personaRepository.findAll().forEach(persona -> {
            PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }
}
