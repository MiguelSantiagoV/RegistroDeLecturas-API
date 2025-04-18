package com.example.libros_api.service;

import com.example.libros_api.model.Libro;
import com.example.libros_api.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros(){
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Integer id){
        return libroRepository.findById(id);
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public void deleteLibro(int id){
        libroRepository.deleteById(id);
    }


}
