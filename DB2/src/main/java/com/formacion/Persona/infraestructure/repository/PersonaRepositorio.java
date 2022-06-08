package com.formacion.Persona.infraestructure.repository;

import com.formacion.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
