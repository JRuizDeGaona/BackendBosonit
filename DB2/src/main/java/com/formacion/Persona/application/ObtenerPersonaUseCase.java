package com.formacion.Persona.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Persona.application.port.ObtenerPersonaPort;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPersonaUseCase implements ObtenerPersonaPort {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public PersonaOutputDTO buscarPorId(int id_persona) throws NotFoundException {
        Persona personaAux;
        PersonaOutputDTO personaDTO;

        personaAux = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        personaDTO = new PersonaOutputDTO(personaAux);

        return personaDTO;
    }

    @Override
    public List<PersonaOutputDTO> buscarTodos() throws Exception {
        List<PersonaOutputDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            throw new Exception("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }

    @Override
    public List<PersonaOutputDTO> buscarPorNombre(String nombre) throws Exception {
        List<PersonaOutputDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            if (persona.getUsuario().equalsIgnoreCase(nombre)) {
                PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
                listaPersonas.add(personaDTO);
            }
        });

        if (listaPersonas.isEmpty()) {
            throw new Exception("Sin usuarios con ese nombre");
        }
        return listaPersonas;
    }
}
