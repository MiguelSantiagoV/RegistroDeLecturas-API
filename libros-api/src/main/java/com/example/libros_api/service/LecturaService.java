package com.example.libros_api.service;

import com.example.libros_api.model.Lectura;
import com.example.libros_api.repository.LecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturaService {

    @Autowired
    private LecturaRepository lecturaRepository;

    public List<Lectura> getAllLecturas(){
        return lecturaRepository.findAll();
    }

    public Lectura getLecturaById(int id){
        return lecturaRepository.findById(id).orElse(null);
    }

    public Lectura saveLectura(Lectura lectura){
        return lecturaRepository.save(lectura);
    }

    public void deleteLectura(int id){
        lecturaRepository.deleteById(id);
    }
}
