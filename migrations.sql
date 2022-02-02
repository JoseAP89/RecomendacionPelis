use peliculas;
DROP TABLE IF EXISTS recomendacion;
DROP TABLE IF EXISTS favorito;
DROP TABLE IF EXISTS catalogo;
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    usuario_id int primary key AUTO_INCREMENT,
    nombre varchar(250) not null,
    apellido1 varchar(250) not null,
    apellido2 varchar(250),
    alias varchar(250) not null,
    edad int,
    genero varchar(1),
    correo varchar(100) not null,
    password varchar(100) not null,
    token varchar(36) not null unique,
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modificado TIMESTAMP 
);

CREATE TABLE catalogo (
    catalogo_id int primary key AUTO_INCREMENT,
    nombre varchar(250),
    descripcion varchar(250),
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modificado TIMESTAMP 
);

CREATE TABLE favorito (
    favorito_id int AUTO_INCREMENT,
    api_id int not null,
    usuario_id int not null,
    nombre_completo varchar(250),
    catalogo_id int not null,
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modificado TIMESTAMP ,
    PRIMARY KEY(favorito_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id),
    FOREIGN KEY (catalogo_id) REFERENCES catalogo(catalogo_id)
);

CREATE TABLE recomendacion (
    recomendacion_id int primary key AUTO_INCREMENT,
    api_id int not null,
    title varchar(300),
    overview varchar(600),
    poster_path varchar(100),
    release_date varchar(20),
    usuario_id int not null,
    catalogo_id int not null,
    genre_ids varchar(200),
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modificado TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id),
    FOREIGN KEY (catalogo_id) REFERENCES catalogo(catalogo_id)

);

INSERT INTO catalogo(nombre, descripcion) VALUES
('Genero', 'Genero de la pelicula'),
('Pelicula', 'Pelicula de la cual se hace referencia'),
('Actor', 'Persona con rol de actor en la pelicula'),
('Director', 'Persona con rol de director en la pelicula');

