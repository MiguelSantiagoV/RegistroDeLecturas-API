package com.example.libros_api.repository;

import com.example.libros_api.model.Lectura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturaRepository extends JpaRepository<Lectura, Integer> {
}
