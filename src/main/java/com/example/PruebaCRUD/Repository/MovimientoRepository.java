package com.example.PruebaCRUD.repository;

import com.example.PruebaCRUD.entity.Cuenta;
import com.example.PruebaCRUD.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

    List<Movimiento> findByCuenta(Cuenta cuenta);

    List<Movimiento> findByFechaBetween(Date fechaInicio, Date fechaFin);

}
