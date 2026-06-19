package com.mundogamer.service;

import org.springframework.stereotype.Service;

import com.mundogamer.dto.AutenticacionFilter;
import com.mundogamer.model.Cliente;
import com.mundogamer.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacionService {

	private final ClienteRepository clienteRepository;

    public Cliente autenticar(AutenticacionFilter filter) {
        return clienteRepository.autenticar(filter.getEmail(), filter.getPassword());
    }
}
