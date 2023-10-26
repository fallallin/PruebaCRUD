package com.example.PruebaCRUD.controller;

import com.example.PruebaCRUD.constant.MovimientoConstant;
import com.example.PruebaCRUD.dto.ErrorDTO;
import com.example.PruebaCRUD.dto.request.MovimientoRequest;
import com.example.PruebaCRUD.dto.response.ListaMovimientosResponse;
import com.example.PruebaCRUD.dto.response.MovimientoResponse;
import com.example.PruebaCRUD.service.impl.MovimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movimiento")
public class MovimientoController {


    @Autowired
    private MovimientoServiceImpl movimientoService;

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> crearMovimiento(@RequestBody MovimientoRequest movimientoRequest) {

        MovimientoResponse movimientoResponse = this.movimientoService.crearMovimiento(movimientoRequest);

        if (movimientoResponse != null && movimientoResponse.getErrors() != null && !movimientoResponse.getErrors().isEmpty()) {
            return new ResponseEntity<>(movimientoResponse.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorDTO(MovimientoConstant.TRANSACTION_CREATED, "la trasaccion ha sido creada exitosamente."));

    }

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> consultarMovientos() {
        ListaMovimientosResponse listaMovimientos = this.movimientoService.consultarMovimientos();

        if (listaMovimientos != null && listaMovimientos.getErrors() != null && !listaMovimientos.getErrors().isEmpty()) {
            return new ResponseEntity<>(listaMovimientos.getErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(listaMovimientos);
    }

}
