package com.mundogamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.dto.ClienteFilter;
import com.mundogamer.dto.ResultadoResponse;

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
	
	public Cliente getOne(String idCliente) {
	    return clienteRepository.findById(idCliente).orElse(null);
	}
	
	private String generarIdCliente() {
	    String id;
	    do {
	        id = String.valueOf((int)(Math.random() * 90000000) + 10000000);
	    } while (clienteRepository.existsById(id));

	    return id;
	}
	
	public ResultadoResponse save(Cliente cliente) {
	    try {
	    	if (cliente.getIdCliente() != null && clienteRepository.existsById(cliente.getIdCliente())) {
	            
	            clienteRepository.save(cliente);
	        } else {
	            
	            cliente.setIdCliente(generarIdCliente());
	            clienteRepository.save(cliente);
	        }

	        return new ResultadoResponse(true, "Cliente guardado exitosamente");

	    } catch (Exception e) {
	        return new ResultadoResponse(false, "Error al guardar el cliente");
	    }
	}
}
