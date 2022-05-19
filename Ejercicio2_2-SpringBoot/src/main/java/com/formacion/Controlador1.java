package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador1 {
    @Autowired
    ArrayList<Ciudad> listaCiudad;

    @PostMapping("/controlador1/addCiudad")
    public void  addCiudad (@RequestBody Ciudad c) {
        listaCiudad.add(c);
    }
}