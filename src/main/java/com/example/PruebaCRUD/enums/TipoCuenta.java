package com.example.PruebaCRUD.enums;

public enum TipoCuenta {
    AHORROS(1, "Ahorros"),
    CORRIENTE(2, "Corriente");

    private final int valor;
    private final String nombre;

    TipoCuenta(int valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public static TipoCuenta fromValor(int valor) {
        for (TipoCuenta tipoCuenta : TipoCuenta.values()) {
            if (tipoCuenta.valor == valor) {
                return tipoCuenta;
            }
        }
        throw new IllegalArgumentException("Valor de tipo de cuenta no válido: " + valor);
    }

    public static TipoCuenta fromNombre(String nombre) {
        for (TipoCuenta tipoCuenta : TipoCuenta.values()) {
            if (tipoCuenta.nombre.equalsIgnoreCase(nombre)) {
                return tipoCuenta;
            }
        }
        throw new IllegalArgumentException("Nombre de tipo de cuenta no válido: " + nombre);
    }
}

