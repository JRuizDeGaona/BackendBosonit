package com.formacion.Student.infraestructure.dtos.output;

import com.formacion.Profesor.domain.Profesor;
import com.formacion.Student.domain.Student;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class SimpleStudentOutputDTO {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    private Integer num_hours_week;
    private String coments;
    private Optional<Profesor> profesor;
    private String branch;
    private List estudios;
    private StudentOutputDTO student;

    public SimpleStudentOutputDTO(Student student){
        this.num_hours_week = student.getNum_hours_week();
        this.coments = student.getComents();
        this.profesor = profesorRepositorio.findById(student.getProfesor().getId_profesor());
        this.branch = student.getBranch();
    }
}
