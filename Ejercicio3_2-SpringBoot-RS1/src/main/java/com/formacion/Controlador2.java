package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/persona")
@RestController
public class Controlador2 {

    @Autowired
    Servicio s;

    @PutMapping("/{id}")
    public List modificarPersona(@PathVariable int id, @RequestBody Map<String,String> mapa) {
        return s.modificarPersona(id, mapa);
    }
}
