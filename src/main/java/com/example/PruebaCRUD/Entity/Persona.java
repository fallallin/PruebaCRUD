package com.example.PruebaCRUD.entity;

public class Persona {

    private int id;

    private String nombre;

    private String genero;

    private String identificacion;

    private int edad;

    private String direccion;

    private int telefono;

    public Persona(int id, String nombre, String genero, String identificacion, int edad, String direccion, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.identificacion = identificacion;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String apellido) {
        this.genero = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String email) {
        this.identificacion = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int gettTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
