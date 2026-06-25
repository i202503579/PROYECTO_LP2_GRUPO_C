package com.mundogamer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mundogamer.dto.CarritoItem;
import com.mundogamer.model.Cliente;
import com.mundogamer.model.Juego;
import com.mundogamer.service.JuegoService;
import com.mundogamer.service.VentaService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("carrito")
@RequiredArgsConstructor
public class CarritoController {
	
	private final VentaService ventaService;
	private final JuegoService juegoService;
	
	@GetMapping("/ver")
    public String verCarrito(HttpSession session, Model model) {
		if (session.getAttribute("usuario") == null) {
	        return "redirect:/producto/inicio"; 
	    }

		List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");
		model.addAttribute("carrito", carrito);
		
	    return "carrito/ver";
    }
	
	@PostMapping("agregar")
	public String agregar(@RequestParam Integer id, @RequestParam Integer cantidad, HttpSession session) {
	    List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");
	    if (carrito == null) {
	        carrito = new ArrayList<>();
	        session.setAttribute("carrito", carrito);
	    }
	    
	    boolean existe = false;
	    for (CarritoItem item : carrito) {
	        if (item.getIdJuego().equals(id)) {
	            item.setCantidad(item.getCantidad() + cantidad);
	            existe = true;
	            break;
	        }
	    }
	    
	    if (!existe) {
	        Juego j = juegoService.getById(id);
	        carrito.add(new CarritoItem(j.getIdJuegos(), j.getDescripcion(), j.getPrecio(), cantidad));
	    }
	    
	    return "redirect:/producto/juegos";
	}
	
	@PostMapping("/finalizar")
    public String finalizarCompra(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");
        
        if (cliente != null && carrito != null && !carrito.isEmpty()) {
            ventaService.registrarVenta(cliente, carrito);
            session.removeAttribute("carrito");
        }
        return "redirect:/producto/inicio";
    }
	
	@PostMapping("/eliminar")
    public String eliminarItem(@RequestParam Integer id, HttpSession session) {
        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");
        if (carrito != null) {
            carrito.removeIf(item -> item.getIdJuego().equals(id));
        }
        return "redirect:/carrito/ver";
    }
}