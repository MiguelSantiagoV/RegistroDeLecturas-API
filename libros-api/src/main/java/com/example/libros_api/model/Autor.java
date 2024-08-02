package com.example.libros_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorId;
    private String nombre;
    private String apellido;
    private String pais;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
}
