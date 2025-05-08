# noinspection SqlNoDataSourceInspectionForFile

-- Script para crear la base de datos y las tablas necesarias para el sistema de gestión de actividades deportivas

-- Creación de la base de datos
DROP DATABASE IF EXISTS ceviche_madrileno;
CREATE DATABASE ceviche_madrileno;

-- Cambiar a la base de datos recién creada
USE ceviche_madrileno;

DROP TABLE IF EXISTS INSCRIPCION;
DROP TABLE IF EXISTS ACTIVIDAD;
DROP TABLE IF EXISTS SALA;
DROP TABLE IF EXISTS USUARIO;

-- Creación de las tablas

CREATE TABLE USUARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(8) UNIQUE,
    esMonitor BOOLEAN default FALSE,
    clave VARCHAR(100),
    nombreApellidos VARCHAR(100),
    ciclo VARCHAR(50),
);

CREATE TABLE SALA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigoSala VARCHAR(10),
    capacidad INT,
    tipoSala VARCHAR(50)
);

CREATE TABLE ACTIVIDAD (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_monitor INT,
    nombre VARCHAR(100),
    id_sala INT,
    descripcion VARCHAR(200),
    nroMaximoInscritos INT,
    fecha DATETIME DEFAULT (CURRENT_TIMESTAMP),
    FOREIGN KEY (id_monitor) REFERENCES USUARIO(id) ON DELETE CASCADE,
    FOREIGN KEY (id_sala) REFERENCES SALA(id) ON DELETE CASCADE
);

CREATE TABLE INSCRIPCION (
    id_usuario INT,
    id_actividad INT,
    PRIMARY KEY (id_usuario, id_actividad),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id) ON DELETE CASCADE,
    FOREIGN KEY (id_actividad) REFERENCES ACTIVIDAD(id) ON DELETE CASCADE
);

-- Inserción de datos
INSERT INTO USUARIO (id,matricula, esMonitor, clave, nombreApellidos, ciclo) VALUES
(1,'123', TRUE, '123', 'Hugo Rubio Crespo', 'DAW'),
(2,'2244193B', FALSE, '123', 'Eduardo Utrilla Quispe', 'DAW'),
(3,'22451182', FALSE, '123', 'Santi', 'DAW');

INSERT INTO SALA (id, codigoSala, capacidad, tipoSala) VALUES
(1,'PPA1', 40, 'Pabellón 1'),
(2,'PPA2', 40, 'Pabellón 2'),
(3,'PPA3', 40, 'Pabellón 3'),
(4,'PPIS', 40, 'Piscina'),
(5,'PPB1', 10, 'Pista de baloncesto 1'),
(6,'PPB2', 10, 'Pista de baloncesto 2'),
(7,'PPE1', 40, 'Pista de atletismo 1'),
(8,'PPE2', 40, 'Pista de atletismo 2');

INSERT INTO ACTIVIDAD (id, id_monitor, nombre, id_sala, descripcion, nroMaximoInscritos) VALUES
(1,1,'Yoga',1, 'Estiramiento del cuerpo y poses',10);

INSERT INTO INSCRIPCION (id_usuario, id_actividad) VALUES
(2,1),
(3,1);


-- selects
-- select * from USUARIO_DESCRIPCION;
-- select * from USUARIO;
-- select * from SALA_ESPACIO;
-- select * from SALA;
-- select * from ACTIVIDAD;
-- select * from INSCRIPCION;
