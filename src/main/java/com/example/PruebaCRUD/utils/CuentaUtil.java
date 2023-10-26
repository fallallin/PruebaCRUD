package com.example.PruebaCRUD.utils;

import com.example.PruebaCRUD.dto.request.CuentaRequest;
import com.example.PruebaCRUD.dto.response.CuentaResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.enums.TipoCuenta;

public class CuentaUtil {


    /**
     * Realiza comparacion entre dos entidades de tipo Cuenta y genera la mas actualizada
     *
     * @param cuentaAnterior
     * @param cuentaNueva
     * @return
     */
    public static Cuenta mapearCuenta(Cuenta cuentaAnterior, CuentaRequest cuentaNueva) {

        Cuenta cuentaActualizada = new Cuenta();

        TipoCuenta tipoCuenta = null;

        if (cuentaNueva.getTipoCuenta() != null) {
            tipoCuenta = TipoCuenta.fromNombre(cuentaNueva.getTipoCuenta());
        }

        cuentaActualizada.setId(cuentaAnterior.getId());
        cuentaActualizada.setNumeroCuenta(cuentaAnterior.getNumeroCuenta());
        cuentaActualizada.setCliente(cuentaAnterior.getCliente());
        cuentaActualizada.setEstado(cuentaNueva.getEstado() != null ? cuentaNueva.getEstado() : cuentaAnterior.getEstado());
        cuentaActualizada.setSaldoInicial(cuentaNueva.getSaldoInicial() != null ? cuentaNueva.getSaldoInicial() : cuentaAnterior.getSaldoInicial());
        cuentaActualizada.setTipoCuenta(cuentaNueva.getTipoCuenta() != null ? tipoCuenta.getValor() : cuentaAnterior.getTipoCuenta());

        return cuentaActualizada;
    }


    /**
     * Mapea una objeto de tipo Cuenta a uno de tipo CuentaResponse
     *
     * @param cuenta
     * @return CuentaResponse
     */
    public static CuentaResponse mapearCuentaResponse(Cuenta cuenta) {

        CuentaResponse cuentaResponse = new CuentaResponse();

        TipoCuenta tipoCuenta = TipoCuenta.fromValor(cuenta.getTipoCuenta());
        cuentaResponse.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaResponse.setTipoCuenta(tipoCuenta.getNombre());
        cuentaResponse.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaResponse.setEstado(cuenta.getEstado());

        return cuentaResponse;
    }
}
