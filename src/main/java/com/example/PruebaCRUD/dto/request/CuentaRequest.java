package com.example.PruebaCRUD.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CuentaRequest {


    @JsonProperty("numero_cuenta")
    private String numeroCuenta;

    @JsonProperty("tipo_cuenta")
    private String tipoCuenta;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("nombre_cliente")
    private String nombreCliente;

    @JsonProperty("saldo_inicial")
    private BigDecimal saldoInicial;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
