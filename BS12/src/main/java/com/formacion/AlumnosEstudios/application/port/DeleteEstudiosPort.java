package com.formacion.AlumnosEstudios.application.port;

import com.formacion.Excepciones.NotFoundException;

public interface DeleteEstudiosPort {
    void deleteEstudios (int id_study) throws NotFoundException;
}
