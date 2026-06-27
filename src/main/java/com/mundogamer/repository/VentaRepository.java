package com.mundogamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundogamer.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, String>{
	List<Venta> findByClienteIdCliente(String idCliente);
}
