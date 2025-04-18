package com.example.libros_api.service;

import com.example.libros_api.model.Autor;
import com.example.libros_api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }

    public Optional<Autor> getAutorById(int id){
        return autorRepository.findById(id);
    }

    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public void deleteAutor(int id){
        autorRepository.deleteById(id);
    }

}
