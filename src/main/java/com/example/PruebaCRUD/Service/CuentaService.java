package com.example.PruebaCRUD.service;

import com.example.PruebaCRUD.dto.request.CuentaRequest;
import com.example.PruebaCRUD.dto.response.CuentaResponse;
import com.example.PruebaCRUD.dto.response.ListaCuentasResponse;
import com.example.PruebaCRUD.entity.Cuenta;

public interface CuentaService {

    /**
     * Consulta el listado de cuentas existentes
     *
     * @return List<CuentaResponse>
     */
    public ListaCuentasResponse consultarCuenta();

    public Cuenta crearCuenta(Cuenta cuenta);

    public CuentaResponse modificarCuenta(CuentaRequest cuentaRequest, String numeroCuenta);

    public CuentaResponse buscarCuenta(String numeroCuenta);

    public CuentaResponse eliminarCuenta(String numeroCuenta);

    /**
     * Verifica si existe el numero de cuenta previamente
     *
     * @param numeroCuenta
     * @return Boolean
     */
    public Boolean existeNumeroCuenta(String numeroCuenta);

    /**
     * Realiza las correspondientes validaciones y mapea del objeto CuentaRequest hacia Entidad Cuenta
     *
     * @param cuentaRequest
     * @return Cuenta
     */
    public Cuenta validarMapearCuenta(CuentaRequest cuentaRequest);


    /**
     * Obtiene la entidad Cuenta por un numero de cuenta
     *
     * @param numeroCuenta
     * @return
     */
    Cuenta getCuentaByAccountNumber(String numeroCuenta);

}
