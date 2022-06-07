package com.formacion.Profesor.domain;

import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Persona.domain.Persona;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "profesor")
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_profesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "coments")
    String coments;
    @Column(name = "branch")
    String branch;

    public Profesor(ProfesorInputDTO profesorDTO){
        setId_profesor(profesorDTO.getId_profesor());
        setPersona(profesorDTO.profesor().getPersona());
        setComents(profesorDTO.getComents());
        setBranch(profesorDTO.getBranch());
    }

    public Profesor(){
    }
}
