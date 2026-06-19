package com.mundogamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundogamer.model.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{

	List<Mensaje> findAllByOrderByMensajeAsc();
}
