package com.example.PruebaCRUD.dto.response;

import java.util.List;

public class ListaCuentasResponse extends HttpErrorResponse {

    private List<CuentaResponse> cuentas;

    public ListaCuentasResponse() {
    }

    public ListaCuentasResponse(List<CuentaResponse> cuentas) {
        this.cuentas = cuentas;
    }

    public List<CuentaResponse> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaResponse> cuentas) {
        this.cuentas = cuentas;
    }
}
