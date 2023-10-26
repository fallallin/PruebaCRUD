package com.example.PruebaCRUD.controller;


import com.example.PruebaCRUD.entity.Cliente;
import com.example.PruebaCRUD.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> consultarClientes() {
        List<Cliente> listaCliente = this.clienteService.consultarCliente();
        return ResponseEntity.ok(listaCliente);
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> crearClientes(@RequestBody Cliente cliente) {
        Cliente clienteCreada = this.clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreada);

    }

    @PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarClientes(@RequestBody Cliente cliente, @PathVariable int id) {
        Cliente clienteModificado = this.clienteService.modificarCliente(cliente, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteModificado);

    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarClientes(@PathVariable int id) {
        Cliente cliente = this.clienteService.buscarCliente(id);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarClientes(@PathVariable int id) {
        this.clienteService.eliminarCliente(id);
        return ResponseEntity.ok().build();
    }

}
