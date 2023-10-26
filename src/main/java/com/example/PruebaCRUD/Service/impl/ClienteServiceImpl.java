package com.example.PruebaCRUD.service.impl;

import com.example.PruebaCRUD.entity.Cliente;
import com.example.PruebaCRUD.repository.ClienteRepository;
import com.example.PruebaCRUD.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> consultarCliente() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente, int id) {
        cliente.setId(id);
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarCliente(int id) {
        return this.clienteRepository.findById(id).get();
    }

    @Override
    public void eliminarCliente(int id) {
        Cliente cliente = this.clienteRepository.findById(id).get();
        cliente.setEstado(false);
        this.clienteRepository.save(cliente);
    }


    @Override
    public Boolean existeCliente(String nombreCliente) {

        List<Cliente> clientes = clienteRepository.findByNombres(nombreCliente);
        return !clientes.isEmpty();
    }


    public Cliente buscarClientePorNombre(String nombreCliente) {
        List<Cliente> clientes = clienteRepository.findByNombres(nombreCliente);
        return clientes.get(0);
    }

}
