create database persona;

use persona;
create table humano(
    id int not null auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    email varchar(50) not null,
    edad int not null,
    sexo varchar(50) not null,
    clave int not null,
    primary key(id)
)