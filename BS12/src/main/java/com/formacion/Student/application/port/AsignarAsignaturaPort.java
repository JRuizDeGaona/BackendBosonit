package com.formacion.Student.application.port;

import com.formacion.Student.domain.Student;
import java.util.List;
import java.util.Map;

public interface AsignarAsignaturaPort {
    Student asignarAsigantura (int id_student, Map<String,Integer> id_study);
    Student desasignarAsignatura (int id_student, Map<String, Integer> id_study);
}
