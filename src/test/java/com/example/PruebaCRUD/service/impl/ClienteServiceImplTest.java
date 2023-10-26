package com.example.PruebaCRUD.service.impl;

import com.example.PruebaCRUD.entity.Cliente;
import com.example.PruebaCRUD.repository.ClienteRepository;
import com.example.PruebaCRUD.service.ClienteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;
    AutoCloseable autoCloseable;
    Cliente cliente;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        clienteService = new ClienteServiceImpl(clienteRepository);

        this.cliente = new Cliente();

        this.cliente.setId(1);
        this.cliente.setNombres("Jose Lema");
        this.cliente.setDireccion("Otavalo sn y principal");
        this.cliente.setTelefono("098254785");
        this.cliente.setContrasena("1234");
        this.cliente.setEstado(true);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void consultarCliente() {
        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.findAll()).thenReturn(new ArrayList<Cliente>(Collections.singleton(cliente)));

        assertThat(clienteService.consultarCliente().get(0).getTelefono()).isEqualTo(cliente.getTelefono());
    }

    @Test
    void crearClienteTest() {
        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        assertThat(clienteService.crearCliente(cliente)).isEqualTo(cliente);
    }

    @Test
    void modificarClienteTest() {
        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        assertThat(clienteService.modificarCliente(cliente, 1)).isEqualTo(cliente);
    }

    @Test
    void buscarClienteTest() {
        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        assertThat(clienteService.buscarCliente(1).getNombres()).isEqualTo(cliente.getNombres());
    }


    @Test
    void existeClienteTest() {

        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.findByNombres("Jose Lema")).thenReturn(new ArrayList<Cliente>(Collections.singleton(cliente)));
        assertThat(clienteService.existeCliente("Jose Lema")).isEqualTo(true);
    }

    @Test
    void buscarClientePorNombreTest() {
        mock(Cliente.class);
        mock(ClienteRepository.class);

        when(clienteRepository.findByNombres("Jose Lema")).thenReturn(new ArrayList<Cliente>(Collections.singleton(cliente)));
        assertThat(clienteService.buscarClientePorNombre("Jose Lema").getDireccion()).isEqualTo(cliente.getDireccion());

    }
}