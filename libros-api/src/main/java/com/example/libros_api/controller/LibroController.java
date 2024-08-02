package com.example.libros_api.controller;

import com.example.libros_api.model.Libro;
import com.example.libros_api.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable int id){
        Libro libro = libroService.getLibroById(id);
        if(libro != null){
            return new ResponseEntity<>(libro, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro){
        Libro savedLibro = libroService.saveLibro(libro);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
