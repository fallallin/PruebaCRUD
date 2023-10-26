package com.example.PruebaCRUD.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoResponse extends HttpErrorResponse {

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("cliente")
    private String cliente;

    @JsonProperty("numero_cuenta")
    private String numeroCuenta;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("saldo_inicial")
    private BigDecimal saldoInicial;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("movimiento")
    private BigDecimal movimiento;

    @JsonProperty("saldo_disponible")
    private BigDecimal saldoDisponible;

    public MovimientoResponse() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public BigDecimal getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(BigDecimal movimiento) {
        this.movimiento = movimiento;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
