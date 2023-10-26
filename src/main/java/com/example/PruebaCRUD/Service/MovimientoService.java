package com.example.PruebaCRUD.service;

import com.example.PruebaCRUD.dto.request.MovimientoRequest;
import com.example.PruebaCRUD.dto.response.ListaMovimientosResponse;
import com.example.PruebaCRUD.dto.response.MovimientoResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.entity.Movimiento;

public interface MovimientoService {

    public MovimientoResponse crearMovimiento(MovimientoRequest movimientoRequest);

    public ListaMovimientosResponse consultarMovimientos();

    public Movimiento consultarUltimoMovimientosPorCuenta(Cuenta cuenta);

    public ListaMovimientosResponse buscarPorRangoDeFechas(String fechaInicio, String fechaFin);
}
