package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/persona")
@RestController
public class Controlador3 {

    @Autowired
    Servicio s;

    @DeleteMapping("/{id}")
    public List borrarPersona(@PathVariable int id) {
        return s.borrarPersona(id);
    }
}
