package com.formacion.Student.infraestructure.dtos.output;

import com.formacion.Persona.domain.Persona;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class StudentOutputDTO {
    private int id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Optional<Profesor> profesor;
    private String branch;
    private List estudios;

    public StudentOutputDTO(Student student){
        setId_student(student.getId_student());
        this.persona = student.getPersona();
        this.num_hours_week = student.getNum_hours_week();
        this.coments = student.getComents();
        this.profesor = Optional.ofNullable(student.getProfesor());
        this.branch = student.getBranch();
    }
}
