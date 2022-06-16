package com.formacion.Persona.application.port;

import com.formacion.Excepciones.NotFoundException;

public interface DeletePersonaPort {
    void deletePersona(int id_persona) throws NotFoundException;
}
