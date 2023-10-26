package com.example.PruebaCRUD.service;

import com.example.PruebaCRUD.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> consultarCliente();

    public Cliente crearCliente(Cliente cliente);

    public Cliente modificarCliente(Cliente cliente, int id);

    public Cliente buscarCliente(int id);

    public void eliminarCliente(int id);

    /**
     * Verifica si el cliente se encuentra registrado en DB
     *
     * @param nombreCliente
     * @return
     */
    public Boolean existeCliente(String nombreCliente);


    /**
     * Buscar un cliente por nombre y devuelve su obejto correspondiente
     *
     * @param nombreCliente
     * @return
     */
    public Cliente buscarClientePorNombre(String nombreCliente);

}
