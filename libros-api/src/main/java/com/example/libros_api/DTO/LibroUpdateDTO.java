package com.example.libros_api.DTO;

import com.example.libros_api.model.Genero;
import com.example.libros_api.model.Siglo;
import lombok.Data;

@Data
public class LibroUpdateDTO {
    private int libroId;
    private String nombre;
    private Genero genero;
    private String subgenero;
    private String idiomaOriginal;
    private int añoPublicacion;
    private Siglo siglo;
    private String epoca;
    private int autorId;
}
