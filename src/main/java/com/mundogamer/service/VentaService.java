package com.mundogamer.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mundogamer.dto.CarritoItem;
import com.mundogamer.model.Cliente;
import com.mundogamer.model.Detalle;
import com.mundogamer.model.Venta;
import com.mundogamer.repository.DetalleRepository;
import com.mundogamer.repository.JuegoRepository;
import com.mundogamer.repository.VentaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VentaService {

	private final VentaRepository ventaRepository;
    private final DetalleRepository detalleRepository;
    private final JuegoRepository juegoRepository;
    
    public List<Venta> getAllVentas() {
    	return ventaRepository.findAll();
    }
    
    public void registrarVenta(Cliente cliente, List<CarritoItem> items) {
        Venta v = new Venta();
        v.setIdVenta("V" + String.valueOf(System.currentTimeMillis()).substring(6));
        v.setCliente(cliente);
        v.setFechaVenta(LocalDate.now());
        v.setEstado("1");
        
        double total = items.stream().mapToDouble(i -> i.getPrecio() * i.getCantidad()).sum();
        v.setMontoTotal(total);
        
        ventaRepository.save(v);
        
        for (CarritoItem item : items) {
            Detalle d = new Detalle();
            d.setVenta(v);
            d.setJuego(juegoRepository.findById(item.getIdJuego()).orElse(null));
            d.setCantidad(item.getCantidad());
            d.setPrecio(item.getPrecio());
            d.setEstado("1");
            detalleRepository.save(d);
        }
    }
}
