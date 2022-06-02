package com.formacion.application.port;

import com.formacion.infraestructure.exception.NotFoundException;

public interface DeletePersonaPort {
    void deletePersona (int id_persona) throws NotFoundException;
}
