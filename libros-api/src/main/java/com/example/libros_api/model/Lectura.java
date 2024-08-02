package com.example.libros_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lecturaId;
    private String idiomaLectura;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
