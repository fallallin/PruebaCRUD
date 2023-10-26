package com.example.PruebaCRUD.controller;

import com.example.PruebaCRUD.constant.CuentaConstant;
import com.example.PruebaCRUD.dto.ErrorDTO;
import com.example.PruebaCRUD.dto.request.CuentaRequest;
import com.example.PruebaCRUD.dto.response.CuentaResponse;
import com.example.PruebaCRUD.dto.response.ListaCuentasResponse;
import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.service.impl.ClienteServiceImpl;
import com.example.PruebaCRUD.service.impl.CuentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cuenta")
public class CuentaController {

    @Autowired
    private CuentaServiceImpl cuentaService;

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> consultarCuentas() {
        ListaCuentasResponse listaCuenta = this.cuentaService.consultarCuenta();

        if (listaCuenta != null && listaCuenta.getErrors() != null && !listaCuenta.getErrors().isEmpty()) {
            return new ResponseEntity<>(listaCuenta.getErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(listaCuenta);
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> crearCuentas(@RequestBody CuentaRequest cuentaRequest) {

        Cuenta cuenta = this.cuentaService.validarMapearCuenta(cuentaRequest);

        if (cuenta.getErrors() != null && !cuenta.getErrors().isEmpty()) {
            return new ResponseEntity<>(cuenta.getErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            cuenta = this.cuentaService.crearCuenta(cuenta);
        } catch (Exception exp) {
            return new ResponseEntity<>(new ErrorDTO(CuentaConstant.ERROR_CREATE_ACCOUNT, CuentaConstant.ERROR_CREATE_ACCOUNT_DB), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorDTO(CuentaConstant.ACCOUNT_CREATED, "la cuenta '" + cuenta.getNumeroCuenta() + "' ha sido creada exitosamente."));

    }

    @PutMapping
    @RequestMapping(value = "/{numeroCuenta}", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarCuentas(@RequestBody CuentaRequest cuentaRequest, @PathVariable String numeroCuenta) {

        CuentaResponse cuentaModificado = this.cuentaService.modificarCuenta(cuentaRequest, numeroCuenta);

        if (cuentaModificado.getErrors() != null && !cuentaModificado.getErrors().isEmpty()) {
            return new ResponseEntity<>(cuentaModificado.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cuentaModificado);

    }

    @GetMapping
    @RequestMapping(value = "/{numeroCuenta}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarCuenta(@PathVariable String numeroCuenta) {

        CuentaResponse cuenta = this.cuentaService.buscarCuenta(numeroCuenta);

        if (cuenta.getErrors() != null && !cuenta.getErrors().isEmpty()) {
            return new ResponseEntity<>(cuenta.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(cuenta);
    }


    @DeleteMapping
    @RequestMapping(value = "/{numeroCuenta}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarCuentas(@PathVariable String numeroCuenta) {

        this.cuentaService.eliminarCuenta(numeroCuenta);
        CuentaResponse cuenta = this.cuentaService.buscarCuenta(numeroCuenta);

        if (cuenta.getErrors() != null && !cuenta.getErrors().isEmpty()) {
            return new ResponseEntity<>(cuenta.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ErrorDTO(CuentaConstant.ACCOUNT_DELETED, "la cuenta '" + cuenta.getNumeroCuenta() + "' ha sido desactivada exitosamente."));
    }

}
