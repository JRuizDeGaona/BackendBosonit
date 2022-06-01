package com.formacion.application;

import com.formacion.application.port.ObtenerPersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPersonaUseCase implements ObtenerPersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO buscarPorId(int id_persona) throws Exception {
        EntityPersona personaAux;
        PersonaOutputDTO personaDTO;

        personaAux = personaRepository.findById(id_persona).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));//406
        personaDTO = new PersonaOutputDTO(personaAux);

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
            throw new Exception("Sin usuarios con ese nombre");
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
            throw new Exception("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }
}
