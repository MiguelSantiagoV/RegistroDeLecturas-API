package com.example.libros_api.controller;

import com.example.libros_api.model.Autor;
import com.example.libros_api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<Autor> getAllAutores(){
        return autorService.getAllAutores();
    }

}
