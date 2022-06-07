package com.formacion.Profesor.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfesorServicio {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    public Optional<Profesor> buscarId(int id_profesor){
        Optional<Profesor> profesor = profesorRepositorio.findById(id_profesor);
        return profesor;
    }

    public ArrayList mostrarTodo() {
        ArrayList profesores = new ArrayList(profesorRepositorio.findAll());
        return profesores;
    }

    public void addProfesor(Profesor p) throws Exception{
        if(p==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            profesorRepositorio.save(p);
            System.out.println("Profesor guardado");
        }
    }

    public void deleteProfesor(int id_profesor) {
        profesorRepositorio.deleteById(id_profesor);
    }
}
