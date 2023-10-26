create table persona(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    identificacion VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(50) NOT NULL
);


create table cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    contrasena VARCHAR(250) NOT NULL,
    estado TINYINT(1)
);


create table tipo_cuenta (
    id_tipo_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo_cuenta VARCHAR(50) NOT NULL
);


CREATE TABLE cuenta (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL,
    id_tipo_cuenta INT,
    estado TINYINT(1),
    saldo_inicial DECIMAL(10, 2),
    id_cliente INT,
    FOREIGN KEY (id_tipo_cuenta) REFERENCES tipo_cuenta(id_tipo_cuenta),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


create table movimiento (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    id_cuenta INT,
    estado TINYINT(1),
    movimiento DECIMAL(10, 2),
    saldo_disponible DECIMAL(10, 2),
    FOREIGN KEY (id_cuenta) REFERENCES cuenta(id_cuenta)
);

INSERT INTO tipo_cuenta (nombre_tipo_cuenta) VALUES ('Ahorro');
INSERT INTO tipo_cuenta (nombre_tipo_cuenta) VALUES ('Corriente');