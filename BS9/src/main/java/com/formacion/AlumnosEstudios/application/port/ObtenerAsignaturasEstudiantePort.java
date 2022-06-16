package com.formacion.AlumnosEstudios.application.port;

import java.util.List;

public interface ObtenerAsignaturasEstudiantePort {
    List obtenerAsignaturas(int id_student);
}
