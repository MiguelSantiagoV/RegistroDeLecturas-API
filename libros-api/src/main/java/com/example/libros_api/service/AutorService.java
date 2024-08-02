package com.example.libros_api.service;

import com.example.libros_api.model.Autor;
import com.example.libros_api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }

    public Autor getAutorById(int id){
        return autorRepository.findById(id).orElse(null);
    }

    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public void deleteAutor(int id){
        autorRepository.deleteById(id);
    }

}
