package com.formacion.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "Profesor")
@Data
@NoArgsConstructor
@Entity
public class EntityProfesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int id_profesor;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch")
    @NotNull
    private String branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private EntityPersona id_persona;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private EntityStudent student;

    @OneToMany(mappedBy = "miProfesor", cascade = CascadeType.ALL)
    private List<EntityStudent> listaEstudiantes;
}
