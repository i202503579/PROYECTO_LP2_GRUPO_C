package com.mundogamer.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mundogamer.dto.JuegoFilter;
import com.mundogamer.dto.ResultadoResponse;
import com.mundogamer.model.Juego;
import com.mundogamer.repository.JuegoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JuegoService {

	private final JuegoRepository juegoRepository;
	
	public List<Juego> getAll(){
		return juegoRepository.findAll();
	}
	
	public Page<Juego> search(JuegoFilter filter, Pageable pageable) {

	    if (filter == null || filter.getIdCategoria() == null || filter.getIdCategoria().isEmpty()) {
	        return juegoRepository.findAllByOrderByDescripcionAsc(pageable);
	    }

	    return juegoRepository.findAllByFilters(filter.getIdCategoria(), pageable);
	}
	
	public Juego getById(Integer id) {
	    return juegoRepository.findById(id).orElse(null);
	}
	
	
// Administrador
	
	public List<Juego> getAllAdmin() {
	    return juegoRepository.findAllByOrderByIdJuegosDesc();
	}
	
	
	public ResultadoResponse create(Juego juego) {
	    try {
	        juegoRepository.save(juego);
	        return new ResultadoResponse(true, "Juego registrado correctamente");
	    } catch (Exception e) {
	        return new ResultadoResponse(false, "Error al registrar el juego");
	    }
	}
}
