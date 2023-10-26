package com.example.PruebaCRUD.dto;

public class ErrorDTO {

    private String mensaje;
    private String detalles;

    public ErrorDTO(String mensaje, String detalles) {
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public ErrorDTO() {

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
