package com.mundogamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.model.Mensaje;
import com.mundogamer.repository.MensajeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MensajeService {

	private final MensajeRepository mensajeRepository;
	
	public List<Mensaje> getAllMensaje() {
		return mensajeRepository.findAllByOrderByMensajeAsc();
	}

	
}
