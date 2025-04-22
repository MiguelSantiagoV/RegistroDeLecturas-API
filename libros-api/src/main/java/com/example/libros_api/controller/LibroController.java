package com.example.libros_api.controller;

import com.example.libros_api.DTO.LibroUpdateDTO;
import com.example.libros_api.exception.ResourceNotFoundException;
import com.example.libros_api.model.Autor;
import com.example.libros_api.model.Libro;
import com.example.libros_api.service.AutorService;
import com.example.libros_api.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/libros")
@CrossOrigin(value = "http://localhost:3000")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable int id) {
        Libro libro = libroService.getLibroById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id: " + id));
        return ResponseEntity.ok(libro);
    }


    @PostMapping
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro){
        if(libro.getAutor() != null && libro.getAutor().getAutorId() >0){
            Optional<Autor> autorOptional = autorService.getAutorById(libro.getAutor().getAutorId());
            if(autorOptional.isPresent()){
                libro.setAutor(autorOptional.get());
            }else{
                throw new ResourceNotFoundException("No se encuentra el autor con el id: "+libro.getAutor().getAutorId());
            }
        }
        Libro savedLibro = libroService.saveLibro(libro);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Integer id, @RequestBody LibroUpdateDTO dto){
        System.out.println("LOG 1. dto: "+dto);
        Optional<Libro> libroOptional = libroService.getLibroById(id);
        if(libroOptional.isEmpty()){
            throw new ResourceNotFoundException("El id recibido no existe: "+id);
        }
        System.out.println("LOG 2. dto: "+dto);
        Libro libro = libroOptional.get();
        libro.setNombre(dto.getNombre());
        libro.setEpoca(dto.getEpoca());
        libro.setSiglo(dto.getSiglo());
        libro.setAñoPublicacion(dto.getAñoPublicacion());
        libro.setGenero(dto.getGenero());
        libro.setSubgenero(dto.getSubgenero());
        libro.setIdiomaOriginal(dto.getIdiomaOriginal());
        System.out.println("LOG 3. dto: "+dto+" libro: "+libro);


        if(dto.getAutorId() > 0){
            Optional<Autor> autor = autorService.getAutorById(dto.getAutorId());
            libro.setAutor(autor.get());
        }else{
            throw new ResourceNotFoundException("El id del autor recibido no existe :"+dto.getAutorId());
        }
        libroService.saveLibro(libro);
        return ResponseEntity.ok(libro);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
