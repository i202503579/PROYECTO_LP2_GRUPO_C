package com.mundogamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.dto.ClienteFilter;
import com.mundogamer.model.Cliente;
import com.mundogamer.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	public List<Cliente> getAllAdmin(){
		return clienteRepository.findAllByOrderByIdClienteAsc();
	}
	
	public List<Cliente> search(ClienteFilter filter) {
		return clienteRepository.findAllByFilters(
		        filter.getIdCliente(),
		        filter.getEstado()
		    );
    }
	
	public Cliente getById(String id) {
	    return clienteRepository.findById(id).orElse(null);
	}
}
