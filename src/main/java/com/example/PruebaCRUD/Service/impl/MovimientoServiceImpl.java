package com.example.PruebaCRUD.service.impl;

import com.example.PruebaCRUD.constant.MovimientoConstant;
import com.example.PruebaCRUD.dto.ErrorDTO;
import com.example.PruebaCRUD.dto.request.MovimientoRequest;
import com.example.PruebaCRUD.dto.response.ListaMovimientosResponse;
import com.example.PruebaCRUD.dto.response.MovimientoResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.entity.Movimiento;
import com.example.PruebaCRUD.repository.MovimientoRepository;
import com.example.PruebaCRUD.service.MovimientoService;
import com.example.PruebaCRUD.utils.DateUtil;
import com.example.PruebaCRUD.utils.MovimientoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaServiceImpl cuentaService;


    @Override
    public MovimientoResponse crearMovimiento(MovimientoRequest movimientoRequest) {

        MovimientoResponse movimientoResponse = new MovimientoResponse();
        List<ErrorDTO> errors = new ArrayList<>();
        Movimiento movimiento = new Movimiento();
        BigDecimal saldoDisponible;

        if (!this.cuentaService.existeNumeroCuenta(movimientoRequest.getNumeroCuenta())) {
            errors.add(new ErrorDTO(MovimientoConstant.ERROR_CREATE_TRANSACTION, "El numero de cuenta '" + movimientoRequest.getNumeroCuenta() + "' no se encuentra resgitrado"));
            movimientoResponse.setErrors(errors);
            return movimientoResponse;
        }

        Cuenta cuenta = this.cuentaService.getCuentaByAccountNumber(movimientoRequest.getNumeroCuenta());

        Movimiento ultimoMovimiento = this.consultarUltimoMovimientosPorCuenta(cuenta);

        // Si es la primera transaccion se le asigna el saldo disponible de la cuenta
        if (ultimoMovimiento == null) {
            saldoDisponible = movimiento.getSaldoDisponible() != null ? movimiento.getSaldoDisponible() : cuenta.getSaldoInicial();
        } else {
            saldoDisponible = ultimoMovimiento.getSaldoDisponible();
        }


        if (!MovimientoUtil.validarSaldo(saldoDisponible, movimientoRequest.getMovimiento())) {
            errors.add(new ErrorDTO(MovimientoConstant.ERROR_CREATE_TRANSACTION, "La cuenta '" + movimientoRequest.getNumeroCuenta() + "' no tiene saldo suficiente para esta transaccion."));
            movimientoResponse.setErrors(errors);
            return movimientoResponse;
        }

        movimiento = MovimientoUtil.mapearMovimiento(movimientoRequest, cuenta, saldoDisponible.add(movimientoRequest.getMovimiento()));
        this.movimientoRepository.save(movimiento);

        return movimientoResponse;

    }

    @Override
    public Movimiento consultarUltimoMovimientosPorCuenta(Cuenta cuenta) {
        List<Movimiento> movimientos = this.movimientoRepository.findByCuenta(cuenta);

        Movimiento ultimoMoviento = null;
        if (!movimientos.isEmpty()) {
            ultimoMoviento = movimientos.get(movimientos.size() - 1);
        }

        return ultimoMoviento;
    }

    @Override
    public ListaMovimientosResponse consultarMovimientos() {
        List<Movimiento> movimientos = (List<Movimiento>) this.movimientoRepository.findAll();
        List<MovimientoResponse> movimientoResponses = MovimientoUtil.mapearListaMovimientos(movimientos);
        return new ListaMovimientosResponse(movimientoResponses);
    }

    @Override
    public ListaMovimientosResponse buscarPorRangoDeFechas(String fechaInicio, String fechaFin) {


        List<Movimiento> movimientos = movimientoRepository.findByFechaBetween(DateUtil.convertStringToDate(fechaInicio), DateUtil.convertStringToDate(fechaFin));
        List<MovimientoResponse> movimientoResponses = MovimientoUtil.mapearListaMovimientos(movimientos);
        return new ListaMovimientosResponse(movimientoResponses);
    }

}
