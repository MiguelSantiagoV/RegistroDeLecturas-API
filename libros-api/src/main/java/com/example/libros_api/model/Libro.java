package com.example.libros_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libroId;
    private String nombre;
    private Genero genero;
    private String subgenero;
    private String idiomaOriginal;
    private int añoPublicacion;
    private Siglo siglo;
    private String epoca;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "libro")
    private List<Lectura> lecturas;

}
