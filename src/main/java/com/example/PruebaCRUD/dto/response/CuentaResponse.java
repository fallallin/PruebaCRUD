package com.example.PruebaCRUD.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CuentaResponse extends HttpErrorResponse {

    @JsonProperty("numero_cuenta")
    private String numeroCuenta;

    @JsonProperty("tipo_cuenta")
    private String tipoCuenta;

    @JsonProperty("saldo_inicial")
    private BigDecimal saldoInicial;

    @JsonProperty("estado")
    private Boolean estado;

    public CuentaResponse() {
    }

    public CuentaResponse(String numeroCuenta, String tipoCuenta, BigDecimal saldoInicial, Boolean estado) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
    }

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

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
