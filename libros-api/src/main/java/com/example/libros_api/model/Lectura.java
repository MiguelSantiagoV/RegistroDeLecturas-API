package com.example.libros_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="lecturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
