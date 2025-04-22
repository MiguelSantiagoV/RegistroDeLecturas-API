package com.example.libros_api.controller;

import com.example.libros_api.exception.ResourceNotFoundException;
import com.example.libros_api.model.Autor;
import com.example.libros_api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin(value = "http://localhost:3000")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<Autor> getAllAutores(){
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable int id){
        Autor autor = autorService.getAutorById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Autor no encontrado con el id: "+id));
        return new ResponseEntity<>(autor, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor){
        Autor saved = autorService.saveAutor(autor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable int id, @RequestBody Autor autorData){
        Optional<Autor> autorOptional = autorService.getAutorById(id);
        if(autorOptional.isEmpty()){
            throw new ResourceNotFoundException("Autor no encontrado con el id: "+id);
        }
        Autor autor = autorOptional.get();
        autor.setNombre(autorData.getNombre());
        autor.setApellidos(autorData.getApellidos());
        autor.setPais(autorData.getPais());
        autorService.saveAutor(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable int id){
        autorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
