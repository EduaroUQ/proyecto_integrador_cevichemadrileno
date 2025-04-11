DROP TABLE IF EXISTS EVENTO;
DROP TABLE IF EXISTS INSCRIPCION;
DROP TABLE IF EXISTS SALA;
DROP TABLE IF EXISTS SALA_ESPACIO;
DROP TABLE IF EXISTS ACTIVIDAD;
DROP TABLE IF EXISTS ACTIVIDAD_DESCRIPCION;
DROP TABLE IF EXISTS USUARIO;
DROP TABLE IF EXISTS USUARIO_DESCRIPCION;

-- Creación de las tablas
CREATE TABLE USUARIO_DESCRIPCION (
    matricula VARCHAR(8) PRIMARY KEY,
    nombreApellidos VARCHAR(100),
    ciclo VARCHAR(50)
);

CREATE TABLE USUARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(8) UNIQUE,
    esMonitor BOOLEAN,
    contraseña VARCHAR(100),
    FOREIGN KEY (matricula) REFERENCES USUARIO_DESCRIPCION(matricula)
);

CREATE TABLE ACTIVIDAD_DESCRIPCION (
    nombre VARCHAR(100) PRIMARY KEY,
    descripcion VARCHAR(200),
    nroMaximoInscritos INT
);

CREATE TABLE ACTIVIDAD (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_monitor INT,
    nombre VARCHAR(100),
    id_sala INT,
    fecha DATETIME DEFAULT (CURRENT_TIMESTAMP),
    FOREIGN KEY (id_monitor) REFERENCES USUARIO(id),
    FOREIGN KEY (nombre) REFERENCES ACTIVIDAD_DESCRIPCION(nombre),
    FOREIGN KEY (id_sala) REFERENCES SALA(id)
);

CREATE TABLE SALA_ESPACIO (
    codigoSala VARCHAR(10) PRIMARY KEY,
    capacidad INT,
    tipoSala VARCHAR(50)
);

CREATE TABLE SALA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigoSala VARCHAR(10),
    FOREIGN KEY (codigoSala) REFERENCES SALA_ESPACIO(codigoSala)
);

CREATE TABLE INSCRIPCION (
    id_usuario INT,
    id_actividad INT,
    PRIMARY KEY (id_usuario, id_actividad),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id),
    FOREIGN KEY (id_actividad) REFERENCES ACTIVIDAD(id)
);


-- Inserción de datos
INSERT INTO USUARIO_DESCRIPCION (matricula, nombreApellidos, ciclo) VALUES
('22441924', 'Hugo Rubio Crespo', 'DAW'),
('2244193B', 'Eduardo Utrilla Quispe', 'DAW'),
('22451182', 'Cristhian Chafloque Chafloque', 'DAW');

INSERT INTO USUARIO (id,matricula, esMonitor, contraseña) VALUES
(1,'22441924', TRUE, '1234monitor'),
(2,'2244193B', FALSE, 'abcd1234'),
(3,'22451182', FALSE, '1234abcd');

INSERT INTO SALA_ESPACIO (codigoSala, capacidad, tipoSala) VALUES
('PPA1', 40, 'Pabellón 1'),
('PPA2', 40, 'Pabellón 2'),
('PPA3', 40, 'Pabellón 3'),
('PPIS', 40, 'Piscina'),
('PPB1', 10, 'Pista de baloncesto 1'),
('PPB2', 10, 'Pista de baloncesto 2'),
('PPE1', 40, 'Pista de atletismo 1'),
('PPE2', 40, 'Pista de atletismo 2');

INSERT INTO SALA (id_sala, codigoSala) VALUES
(1,'PPA1'), 
(2,'PPA2'), 
(3,'PPA3'), 
(4,'PPIS'),
(5,'PPB1'), 
(6,'PPB2');

INSERT INTO ACTIVIDAD (id, id_monitor, nombre, id_sala) VALUES
(1,1,'Yoga',1);

INSERT INTO INSCRIPCION (id_usuario, id_actividad) VALUES
(2,1),
(3,1);

INSERT INTO ACTIVIDAD_DESCRIPCION (nombre, descripcion, nroMaximoInscritos) VALUES
('Yoga', 'Estiramiento del cuerpo y poses',10);