package com.mundogamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundogamer.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer>{

	List<Detalle> findByVenta_IdVenta(String idVenta);
}
