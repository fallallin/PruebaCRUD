package com.example.PruebaCRUD.utils;

import com.example.PruebaCRUD.dto.request.MovimientoRequest;
import com.example.PruebaCRUD.dto.response.MovimientoResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.entity.Movimiento;
import com.example.PruebaCRUD.enums.TipoCuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MovimientoUtil {

    /**
     * Compara el saldo disponible con el valor del movimiento, si tiene saldo sufieite retorna true
     *
     * @param saldoDisponible
     * @param valorMovimiento
     * @return Boolean
     */
    public static Boolean validarSaldo(BigDecimal saldoDisponible, BigDecimal valorMovimiento) {

        // Verificar que es un retiro
        if (valorMovimiento.compareTo(BigDecimal.ZERO) < 0) {
            BigDecimal resultado = saldoDisponible.add(valorMovimiento);
            // Retorna true si el valor es positivo
            return (resultado.compareTo(BigDecimal.ZERO) > 0);
        }

        return true;
    }

    /**
     * @param movimientoRequest
     * @param cuenta
     * @param saldoDisponible
     * @return
     */
    public static Movimiento mapearMovimiento(MovimientoRequest movimientoRequest, Cuenta cuenta, BigDecimal saldoDisponible) {

        Movimiento movimiento = new Movimiento();

        movimiento.setFecha(movimientoRequest.getFecha());
        movimiento.setEstado(movimientoRequest.getEstado() != null ? movimientoRequest.getEstado() : true);
        movimiento.setMovimiento(movimientoRequest.getMovimiento());
        movimiento.setCuenta(cuenta);
        movimiento.setSaldoDisponible(saldoDisponible);

        return movimiento;
    }


    /**
     * Mapea del listado de entidades Moviento hacia el listado MovimientoResponse
     *
     * @param movimientos
     * @return List<MovimientoResponse>
     */
    public static List<MovimientoResponse> mapearListaMovimientos(List<Movimiento> movimientos) {
        List<MovimientoResponse> movimientoResponses = new ArrayList<>();
        MovimientoResponse movimientoResponse = null;

        TipoCuenta tipoCuenta = null;


        for (Movimiento movimiento : movimientos) {

            if (movimiento.getCuenta().getTipoCuenta() != null) {
                tipoCuenta = TipoCuenta.fromValor(movimiento.getCuenta().getTipoCuenta());
            }

            movimientoResponse = new MovimientoResponse();
            movimientoResponse.setFecha(movimiento.getFecha());
            movimientoResponse.setCliente(movimiento.getCuenta().getCliente().getNombres());
            movimientoResponse.setTipo(tipoCuenta.getNombre());
            movimientoResponse.setEstado(movimiento.getEstado());
            movimientoResponse.setMovimiento(movimiento.getMovimiento());
            movimientoResponse.setSaldoDisponible(movimiento.getSaldoDisponible());
            movimientoResponse.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
            movimientoResponse.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());

            movimientoResponses.add(movimientoResponse);
        }

        return movimientoResponses;

    }
}
