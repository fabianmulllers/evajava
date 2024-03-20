package com.example.evajava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EvaluacionController {
	
    @GetMapping
    public String mostrarMensaje() {
        return "Bienvenido a la evaluacion";
    }

}
