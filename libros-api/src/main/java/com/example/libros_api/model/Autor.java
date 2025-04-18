package com.example.libros_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="autores")
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorId;
    private String nombre;
    private String apellidos;
    private String pais;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Libro> libros;
}
