package com.example.PruebaCRUD.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoRequest {

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("numero_cuenta")
    private String numeroCuenta;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("saldo_disponible")
    private BigDecimal saldoDisponible;

    @JsonProperty("movimiento")
    private BigDecimal movimiento;


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public BigDecimal getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(BigDecimal movimiento) {
        this.movimiento = movimiento;
    }
}
