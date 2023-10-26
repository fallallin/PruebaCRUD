package com.example.PruebaCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_cuenta")
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cuenta")
    private int id;

    @Column(name = "numero_tipo_cuenta")
    private String numeroTipoCuenta;

    public TipoCuenta() {
    }

    public TipoCuenta(int id, String numeroTipoCuenta) {
        this.id = id;
        this.numeroTipoCuenta = numeroTipoCuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTipoCuenta() {
        return numeroTipoCuenta;
    }

    public void setNumeroTipoCuenta(String numeroTipoCuenta) {
        this.numeroTipoCuenta = numeroTipoCuenta;
    }
}
