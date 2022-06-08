package com.formacion.Profesor.infraestructure.repository;

import com.formacion.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
}
