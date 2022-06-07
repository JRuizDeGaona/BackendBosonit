package com.formacion.infraestructure.repository;

import com.formacion.domain.EntityPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<EntityPersona, Integer> {
}
