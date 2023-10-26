package com.example.PruebaCRUD.controller;

import com.example.PruebaCRUD.dto.response.ListaMovimientosResponse;
import com.example.PruebaCRUD.service.impl.MovimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reportes")
public class ReporteController {

    @Autowired
    private MovimientoServiceImpl movimientoService;


    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> consultarMovientosPorFechas(@RequestParam List<String> fecha) {
        ListaMovimientosResponse listaMovimientos = this.movimientoService.buscarPorRangoDeFechas(fecha.get(0), fecha.get(1));

        if (listaMovimientos != null && listaMovimientos.getErrors() != null && !listaMovimientos.getErrors().isEmpty()) {
            return new ResponseEntity<>(listaMovimientos.getErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(listaMovimientos);
    }

}
