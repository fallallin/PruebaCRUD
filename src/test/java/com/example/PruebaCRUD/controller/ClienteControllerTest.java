package com.example.PruebaCRUD.controller;

import com.example.PruebaCRUD.entity.Cliente;
import com.example.PruebaCRUD.service.impl.ClienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteServiceImpl clienteService;
    Cliente clienteUno;
    Cliente clienteDos;
    List<Cliente> clienteList = new ArrayList<>();

    @BeforeEach
    void setUp() {

        this.clienteUno = new Cliente();
        this.clienteDos = new Cliente();

        this.clienteUno.setId(1);
        this.clienteUno.setNombres("Jose Lema");
        this.clienteUno.setDireccion("Otavalo sn y principal");
        this.clienteUno.setTelefono("098254785");
        this.clienteUno.setContrasena("1234");
        this.clienteUno.setEstado(true);

        this.clienteDos.setId(2);
        this.clienteDos.setNombres("Marianela Montalvo");
        this.clienteDos.setDireccion("Amazonas y NNUU");
        this.clienteDos.setTelefono("097548965");
        this.clienteDos.setContrasena("5678");
        this.clienteDos.setEstado(true);

        clienteList.add(clienteUno);
        clienteList.add(clienteDos);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void consultarClientesTest() throws Exception {

        when(clienteService.consultarCliente()).thenReturn(clienteList);
        this.mockMvc.perform(get("/clientes")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void crearClientesTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(clienteUno);

        when(clienteService.crearCliente(clienteUno)).thenReturn(clienteUno);
        this.mockMvc.perform(post("/clientes").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void modificarClientes() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(clienteUno);

        when(clienteService.crearCliente(clienteUno)).thenReturn(clienteUno);
        this.mockMvc.perform(put("/clientes/1").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void buscarClientes() throws Exception {
        when(clienteService.buscarCliente(1)).thenReturn(clienteUno);
        this.mockMvc.perform(get("/clientes/1")).andDo(print()).andExpect(status().isOk());
    }
    
}