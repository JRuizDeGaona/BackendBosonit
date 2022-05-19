package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador2 {
    @Autowired
    ArrayList<Ciudad> listaCiudad;

    @GetMapping("/controlador2/getCiudad")
    public String getCiudad () {
        StringBuilder sb = new StringBuilder();
        for (Ciudad c: listaCiudad) {
            sb.append("Ciudad: ");
            sb.append(c.getNombre());
            sb.append(" | Número de Habitantes: ");
            sb.append(c.getNumeroHabitantes());
            sb.append("\n");
        }
        return sb+"";
    }
}
