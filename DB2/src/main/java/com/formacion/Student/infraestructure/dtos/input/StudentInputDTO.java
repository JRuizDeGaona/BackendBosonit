package com.formacion.Student.infraestructure.dtos.input;

import lombok.Data;
import java.util.List;

@Data
public class StudentInputDTO{
    int id_student;
    int id_persona;
    int num_hours_week;
    String coments;
    int id_profesor;
    String branch;
    List estudios;
}
