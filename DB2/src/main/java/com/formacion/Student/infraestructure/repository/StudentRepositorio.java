package com.formacion.Student.infraestructure.repository;

import com.formacion.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositorio extends JpaRepository<Student, Integer> {
}
