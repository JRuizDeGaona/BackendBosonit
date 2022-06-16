package com.formacion.AlumnosEstudios.infraestructure.repository;

import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosEstudiosRepositorio extends JpaRepository<AlumnosEstudios, Integer> {
}
