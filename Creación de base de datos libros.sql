#CREATE DATABASE libros;
#USE libros;

CREATE TABLE autores(
	autor_id INT AUTO_INCREMENT PRIMARY KEY, 
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255),
    pais VARCHAR(255)
	
);

CREATE TABLE libros(
	libro_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL, 
	autor_id INT NOT NULL,
	genero ENUM('Cuento','Novela','Poesía','Teatro','Ensayo','Crónica'), 
    subgenero VARCHAR(255), 
    idioma_original VARCHAR(255), 
    año_publicacion INT,
    siglo ENUM('XX a.C.', 'XIX a.C.', 'XVIII a.C.', 'XVII a.C.', 'XVI a.C.', 'XV a.C.', 'XIV a.C.', 'XIII a.C.', 'XII a.C.', 'XI a.C.', 'X a.C.', 'IX a.C.', 
    'VIII a.C.', 'VII a.C.', 'VI a.C.', 'V a.C.', 'IV a.C.', 'III a.C.', 'II a.C.', 'I a.C.', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X', 'XI', 
    'XII', 'XIII', 'XIV', 'XV', 'XVI', 'XVII', 'XVIII', 'XIX', 'XX', 'XXI'),
    epoca VARCHAR(255),
    FOREIGN KEY (autor_id) REFERENCES autores(autor_id)
);



CREATE TABLE lecturas(
	lectura_id INT AUTO_INCREMENT PRIMARY KEY, 
    libro_id INT NOT NULL,
    idioma VARCHAR(255), 
    fecha_inicio DATE, 
    fecha_fin DATE, 
    FOREIGN KEY (libro_id) REFERENCES libros(libro_id)
);