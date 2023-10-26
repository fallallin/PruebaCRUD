package com.example.PruebaCRUD.dto.response;

import com.example.PruebaCRUD.dto.ErrorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class HttpErrorResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorDTO> errors;

    public HttpErrorResponse() {
    }

    public HttpErrorResponse(List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
