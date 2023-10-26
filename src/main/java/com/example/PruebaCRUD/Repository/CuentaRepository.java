package com.example.PruebaCRUD.repository;

import com.example.PruebaCRUD.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuentaRepository extends CrudRepository<Cuenta, Integer> {


    List<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
