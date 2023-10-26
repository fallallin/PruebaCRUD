package com.example.PruebaCRUD.entity;

import com.example.PruebaCRUD.dto.response.HttpErrorResponse;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuenta")
public class Cuenta extends HttpErrorResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private int id;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    // @ManyToOne
    // @JoinColumn(name = "id_tipo_cuenta")
    @Column(name = "id_tipo_cuenta")
    // private TipoCuenta tipoCuenta;
    private Integer tipoCuenta;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(int id, String numeroCuenta, Integer tipoCuenta, Boolean estado, BigDecimal saldoInicial, Cliente cliente) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
        this.cliente = cliente;
        this.saldoInicial = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
