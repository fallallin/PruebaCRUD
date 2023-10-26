package com.example.PruebaCRUD.repository;

import com.example.PruebaCRUD.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    // Método de búsqueda por nombre
    List<Cliente> findByNombres(String nombres);
}
