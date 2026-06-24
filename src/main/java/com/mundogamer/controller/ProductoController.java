package com.mundogamer.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mundogamer.dto.JuegoFilter;
import com.mundogamer.model.Juego;
import com.mundogamer.service.CategoriaService;
import com.mundogamer.service.JuegoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("producto")
public class ProductoController {

	private final JuegoService juegoService;
	private final CategoriaService categoriaService;
	
	@GetMapping("inicio")
	public String inicio() {
		return "/producto/inicio";
	}

	@GetMapping("nosotros")
	public String nosotros() {
		return "/producto/nosotros";
	}
	
	@GetMapping("/contactanos")
    public String Contacto() {
        return "/producto/contactanos"; 
    }
	
	@GetMapping("/juegos")
	public String listaJuegos(@ModelAttribute JuegoFilter filter, @RequestParam(defaultValue = "0") int page, Model model) {

	    Pageable pageable = PageRequest.of(page, 9);
	    Page<Juego> pagina = juegoService.search(filter, pageable);

	    model.addAttribute("pagina", pagina);
		model.addAttribute("lstCategoria", categoriaService.getAll());
		model.addAttribute("filter", filter);
		return "producto/juegos";
	}
	
	@GetMapping("/detalles_juego")
    public String detalleJuego(@RequestParam Integer id , Model model) {
		model.addAttribute("juego", juegoService.getById(id));
		model.addAttribute("lstCategoria", categoriaService.getAll());
        return "/producto/detalles_juego"; 
    }
}
