package com.mundogamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.model.Detalle;
import com.mundogamer.repository.DetalleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleService {

	private final DetalleRepository detalleRepository;

    public List<Detalle> listarPorVenta(String idVenta) {
        return detalleRepository.findByVenta_IdVenta(idVenta);
    }
}
