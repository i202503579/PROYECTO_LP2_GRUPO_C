package com.mundogamer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mundogamer.model.Cliente;
import com.mundogamer.service.DetalleService;
import com.mundogamer.service.VentaService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("compras")
@RequiredArgsConstructor
public class ClienteCompraController {

    private final VentaService ventaService;
    private final DetalleService detalleService;

    @GetMapping("historial")
    public String historialCliente(HttpSession session, Model model) {
        Cliente clienteLogueado = (Cliente) session.getAttribute("usuario");
        
        if (clienteLogueado == null) {
            return "redirect:/producto/inicio";
        }

        model.addAttribute("lstVentas", ventaService.listarPorCliente(clienteLogueado.getIdCliente()));
        return "cliente/historial-compras";
    }

    @GetMapping("detalle-compra/{id}")
    public String verDetalleCliente(@PathVariable String id, HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/producto/inicio";
        }
        
        model.addAttribute("detalles", detalleService.listarPorVenta(id));
        return "cliente/detalle-venta";
    }
}