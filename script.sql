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
(1,'123', TRUE, '123', 'Hugo Rubio Crespo', 'DAW'),
(2,'2244193B', FALSE, '123', 'Eduardo Utrilla Quispe', 'DAW'),
(3,'22451182', FALSE, '123', 'Santi Nuñez', 'DAM'),
(4,'2245118C', FALSE, '123', 'Sara Villanueva', 'DAW'),
(5,'2245119D', TRUE, '123', 'Raúl Rodriguez', 'ASIR'),
(6,'2245118E', FALSE, '123', 'Herminia Edoko', 'A3D'),
(7,'2245117A', FALSE, '123', 'Diego Flores', 'DAM'),
(8,'2245112F', FALSE, '123', 'Rosa Meltrozo', 'EI'),
(9,'2245112G', TRUE, '123', 'Debora Meltrozo', 'CI'),
(10,'2245114H', FALSE, '123', 'Armando Esteban Quito', 'DAM'),
(11,'2245111I', FALSE, '123', 'Aquiles Caigo', 'ASIR'),
(12,'2245112J', TRUE, '123', 'Pablo Alborán', 'A3D'),
(13,'2245113K', TRUE, '123', 'Benito Camelo', 'ASIR'),
(14,'2245114L', TRUE, '123', 'María Garrido Bravo', 'EI'),
(15,'2245115M', TRUE, '123', 'Julián Martinez Cruz', 'CI'),
(16,'2245116N', FALSE, '123', 'Álvaro Bulldog Inglés', 'A3D'),
(17,'2245117O', FALSE, '123', 'Dolores Delano', 'CI'),
(18,'2245118P', FALSE, '123', 'Lucho Portuano', 'EI'),
(19,'2245118Q', TRUE, '123', 'Jorge Nitales ', 'DAW'),
(20,'2245119R', TRUE, '123', 'Paco Gertes', 'EI');

INSERT INTO SALA (id, codigoSala, capacidad, tipoSala) VALUES
(1,'PPA1', 40, 'Pabellón 1'),
(2,'PPA2', 40, 'Pabellón 2'),
(3,'PPA3', 40, 'Pabellón 3'),
(4,'PPIS', 40, 'PPIS'),
(5,'PPB1', 10, 'Pista de baloncesto 1'),
(6,'PPB2', 10, 'Pista de baloncesto 2'),
(7,'PPE1', 40, 'Pista de atletismo 1'),
(8,'PPE2', 40, 'Pista de atletismo 2');

INSERT INTO ACTIVIDAD (id, id_monitor, nombre, id_sala, descripcion, nroMaximoInscritos) VALUES
(1,1,'Yoga',1, 'Estiramiento del cuerpo y poses',10),
(2,1,'Box',2, 'Box descripcion',5),
(3,1,'Ciclismo',3, 'Ciclismo descripcion',15),
(4,1,'Natación',4, 'Natación descripcion',10),
(5,1,'Futbol 5',8, 'Futbol descripcion',15),
(6,1,'Kick Boxing',2, 'Kick Boxing descripcion',10),
(7,1,'Pilates',1, 'Pilates descripcion',20),
(8,1,'Calistenia',3, 'Calistenia descripcion',15),
(9,1,'Powerlifting',2, 'Powerlifting descripcion',10),
(10,1,'Beisbol',1, 'Beisbol descripcion',10),
(11,5,'Basket',5, 'Basket descripcion',15),
(12,1,'Voley',6, 'Voley descripcion',10);


INSERT INTO INSCRIPCION (id_usuario, id_actividad) VALUES
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(2,7),
(2,8),
(2,9),
(2,10),
(2,11);



-- selects
-- select * from USUARIO;
-- select * from SALA;
-- select * from ACTIVIDAD;
-- select * from INSCRIPCION;

-- SELECT a.id, a.id_monitor, a.nombre, a.id_sala, a.descripcion, a.nroMaximoInscritos, a.fecha, s.codigoSala, s.capacidad, s.tipoSala FROM actividad a, sala s where a.id_sala = s.id

-- select a.id as idActividad, a.nombre as nombreActividad, a.fecha as fechaActividad, s.tipoSala  from INSCRIPCION i , SALA s, ACTIVIDAD a where i.id_actividad = a.id and s.id = a.id_sala and i.id_usuario = 2 ;