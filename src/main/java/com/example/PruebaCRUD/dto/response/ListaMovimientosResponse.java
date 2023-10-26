package com.example.PruebaCRUD.dto.response;

import java.util.List;

public class ListaMovimientosResponse extends HttpErrorResponse {

    private List<MovimientoResponse> movimientos;

    public ListaMovimientosResponse() {
    }

    public ListaMovimientosResponse(List<MovimientoResponse> movimientos) {
        this.movimientos = movimientos;
    }

    public List<MovimientoResponse> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoResponse> movimientos) {
        this.movimientos = movimientos;
    }
}
