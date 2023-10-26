package com.example.PruebaCRUD.service.impl;

import com.example.PruebaCRUD.constant.CuentaConstant;
import com.example.PruebaCRUD.dto.ErrorDTO;
import com.example.PruebaCRUD.dto.request.CuentaRequest;
import com.example.PruebaCRUD.dto.response.CuentaResponse;
import com.example.PruebaCRUD.dto.response.ListaCuentasResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.enums.TipoCuenta;
import com.example.PruebaCRUD.repository.ClienteRepository;
import com.example.PruebaCRUD.repository.CuentaRepository;
import com.example.PruebaCRUD.service.CuentaService;
import com.example.PruebaCRUD.utils.CuentaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {


    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public ListaCuentasResponse consultarCuenta() {

        ListaCuentasResponse cuentasResponse = new ListaCuentasResponse();
        List<CuentaResponse> listaCuentas = new ArrayList<>();
        TipoCuenta tipoCuenta = null;
        CuentaResponse cuentaResponse = new CuentaResponse();

        List<Cuenta> cuentas = (List<Cuenta>) this.cuentaRepository.findAll();

        if (!cuentas.isEmpty()) {
            for (Cuenta cuenta : cuentas) {
                cuentaResponse = CuentaUtil.mapearCuentaResponse(cuenta);
                listaCuentas.add(cuentaResponse);
            }

            cuentasResponse.setCuentas(listaCuentas);
            return cuentasResponse;
        }

        cuentasResponse.setErrors(new ArrayList<>());
        cuentasResponse.getErrors().add(new ErrorDTO(CuentaConstant.ERROR_GET_ACCOUNT, "No se encontraron registros de cuentas"));

        return cuentasResponse;
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {

        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaResponse modificarCuenta(CuentaRequest cuentaRequest, String numeroCuenta) {

        List<ErrorDTO> erros = new ArrayList<>();
        Cuenta cuentaActualizada = null;
        CuentaResponse cuentaResponse = new CuentaResponse();
        List<Cuenta> cuentas = cuentaRepository.findByNumeroCuenta(numeroCuenta);

        if (cuentas != null && !cuentas.isEmpty()) {
            cuentaActualizada = CuentaUtil.mapearCuenta(cuentas.get(0), cuentaRequest);
            this.cuentaRepository.save(cuentaActualizada);
            cuentaResponse = CuentaUtil.mapearCuentaResponse(cuentaActualizada);
            return cuentaResponse;
        }

        erros.add(new ErrorDTO(CuentaConstant.ERROR_GET_ACCOUNT, "En numero de cuenta: '" + numeroCuenta + "' no existe."));
        cuentaResponse.setErrors(erros);

        return cuentaResponse;

    }

    @Override
    public CuentaResponse buscarCuenta(String numeroCuenta) {

        List<ErrorDTO> erros = new ArrayList<>();
        CuentaResponse cuentaResponse = new CuentaResponse();

        List<Cuenta> cuentas = cuentaRepository.findByNumeroCuenta(numeroCuenta);

        if (cuentas != null && !cuentas.isEmpty()) {
            cuentaResponse = CuentaUtil.mapearCuentaResponse(cuentas.get(0));
            return cuentaResponse;
        }

        erros.add(new ErrorDTO(CuentaConstant.ERROR_GET_ACCOUNT, "En numero de cuenta: '" + numeroCuenta + "' no existe."));
        cuentaResponse.setErrors(erros);

        return cuentaResponse;
    }

    @Override
    public Cuenta getCuentaByAccountNumber(String numeroCuenta) {

        Cuenta cuenta = new Cuenta();

        List<Cuenta> cuentas = cuentaRepository.findByNumeroCuenta(numeroCuenta);

        if (cuentas != null && !cuentas.isEmpty()) {
            cuenta = cuentas.get(0);
        }

        return cuenta;
    }

    @Override
    public CuentaResponse eliminarCuenta(String numeroCuenta) {


        List<ErrorDTO> erros = new ArrayList<>();
        CuentaResponse cuentaResponse = new CuentaResponse();

        List<Cuenta> cuentas = cuentaRepository.findByNumeroCuenta(numeroCuenta);

        if (cuentas != null && !cuentas.isEmpty()) {
            cuentas.get(0).setEstado(false);
            this.cuentaRepository.save(cuentas.get(0));
            cuentaResponse = CuentaUtil.mapearCuentaResponse(cuentas.get(0));
            return cuentaResponse;
        }

        erros.add(new ErrorDTO(CuentaConstant.ERROR_GET_ACCOUNT, "En numero de cuenta: '" + numeroCuenta + "' no existe."));
        cuentaResponse.setErrors(erros);

        return cuentaResponse;

    }

    @Override
    public Boolean existeNumeroCuenta(String numeroCuenta) {

        List<Cuenta> cuentas = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        return !cuentas.isEmpty();
    }

    @Override
    public Cuenta validarMapearCuenta(CuentaRequest cuentaRequest) {


        List<ErrorDTO> errors = new ArrayList<>();
        TipoCuenta tipoCuenta = null;
        Cuenta cuenta = new Cuenta();

        if (!this.clienteService.existeCliente(cuentaRequest.getNombreCliente())) {
            errors.add(new ErrorDTO(CuentaConstant.ERROR_CREATE_ACCOUNT, "El cliente '" + cuentaRequest.getNombreCliente() + "' no se encuentra resgitrado"));
        }

        if (this.existeNumeroCuenta(cuentaRequest.getNumeroCuenta())) {
            errors.add(new ErrorDTO(CuentaConstant.ERROR_CREATE_ACCOUNT, "El numero de cuenta '" + cuentaRequest.getNumeroCuenta() + "' ya se encuentra resgitrado"));
        }

        try {
            tipoCuenta = TipoCuenta.fromNombre(cuentaRequest.getTipoCuenta());
        } catch (IllegalArgumentException e) {
            errors.add(new ErrorDTO(CuentaConstant.ERROR_CREATE_ACCOUNT, e.getMessage()));
        }

        if (!errors.isEmpty()) {
            cuenta.setErrors(errors);
            return cuenta;
        }

        cuenta.setTipoCuenta(tipoCuenta.getValor());
        cuenta.setCliente(clienteService.buscarClientePorNombre(cuentaRequest.getNombreCliente()));
        cuenta.setNumeroCuenta(cuentaRequest.getNumeroCuenta());
        cuenta.setSaldoInicial(cuentaRequest.getSaldoInicial());
        cuenta.setEstado(true);

        return cuenta;
    }

}
