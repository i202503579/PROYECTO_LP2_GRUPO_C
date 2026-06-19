package com.mundogamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.dto.ResultadoResponse;
import com.mundogamer.model.Categoria;
import com.mundogamer.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria getOne(String idCategoria) {
		return categoriaRepository.findById(idCategoria).orElseThrow();
	}
	
	public ResultadoResponse save(Categoria categoria) {
	    try {
	    	if (categoria.getIdCategoria() == null || categoria.getIdCategoria().isEmpty()) {
	            long total = categoriaRepository.count();
	            String nuevoId = String.format("CAT%03d", total + 1);
	            categoria.setIdCategoria(nuevoId);
	        }
	        categoriaRepository.save(categoria);
	        return new ResultadoResponse(true, "Categoría guardada exitosamente");
	    } catch (Exception e) {
	        return new ResultadoResponse(false, "Error al guardar la categoría");
	    }
	}
}
