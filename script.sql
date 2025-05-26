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
    ciclo VARCHAR(50)
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
(1,'123', TRUE, '123', 'Sara Villanueva Rosa', 'TAFD');

INSERT INTO SALA (id, codigoSala, capacidad, tipoSala) VALUES
(1,'PPA1', 40, 'Pabellón 1'),
(2,'PPA2', 40, 'Pabellón 2'),
(3,'PPA3', 40, 'Pabellón 3'),
(4,'PPIS', 40, 'PPIS'),
(5,'PPB1', 10, 'Pista de baloncesto 1'),
(6,'PPB2', 10, 'Pista de baloncesto 2'),
(7,'PPE1', 40, 'Pista de atletismo 1'),
(8,'PPE2', 40, 'Pista de atletismo 2');

-- INSERT INTO ACTIVIDAD (id, id_monitor, nombre, id_sala, descripcion, nroMaximoInscritos) VALUES



-- INSERT INTO INSCRIPCION (id_usuario, id_actividad) VALUES






-- selects
-- select * from USUARIO;
-- select * from SALA;
-- select * from ACTIVIDAD;
-- select * from INSCRIPCION;

-- SELECT a.id, a.id_monitor, a.nombre, a.id_sala, a.descripcion, a.nroMaximoInscritos, a.fecha, s.codigoSala, s.capacidad, s.tipoSala FROM actividad a, sala s where a.id_sala = s.id

-- select a.id as idActividad, a.nombre as nombreActividad, a.fecha as fechaActividad, s.tipoSala  from INSCRIPCION i , SALA s, ACTIVIDAD a where i.id_actividad = a.id and s.id = a.id_sala and i.id_usuario = 2 ;

-- select a.nombre, a.descripcion, a.nroMaximoInscritos - (select count(*) from inscripcion i where i.id_actividad = a.id) as totalPlazasDisponibles, a.nroMaximoInscritos , s.tipoSala, u.nombreApellidos from ACTIVIDAD a, USUARIO u, SALA s where a.id_monitor = u.id and a.id_sala = s.id and a.id