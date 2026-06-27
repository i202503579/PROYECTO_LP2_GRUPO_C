package com.mundogamer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.mundogamer.dto.AutenticacionFilter;
import com.mundogamer.model.Cliente;
import com.mundogamer.service.AutenticacionService;
import com.mundogamer.service.ClienteService;
import com.mundogamer.util.Alert;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final AutenticacionService autenticacionService;
	private final ClienteService clienteService;

	@PostMapping("/login")
	public String procesarLogin(
			@ModelAttribute AutenticacionFilter filter,
			Model model, 
				HttpSession session,
				RedirectAttributes flash
			) 
	{
		var cliente = autenticacionService.autenticar(filter);
		

		if (cliente == null) {
			flash.addFlashAttribute("error", "Correo o contraseña incorrectos");
			return "redirect:/producto/inicio";
		}
		
		if (!"1".equals(cliente.getEstado())) {
		    flash.addFlashAttribute(
		        "alert",
		        Alert.sweetAlertError("La cuenta se encuentra inactiva")
		    );

		    System.out.println("login");
		    return "redirect:/producto/inicio";
		}
		
		session.setAttribute("usuario", cliente);
		
		//session.setMaxInactiveInterval(5000);
		
		String alert = Alert.sweetImageUrl("Bienvenido a MUNDOGAMER", cliente.getFullName(), "/img/felicidades.gif");
		flash.addFlashAttribute("alert",alert);
	    if ("ADMIN".equals(cliente.getRol())) {
	        return "redirect:/admin/lista-juegos";
	    }

	    return "redirect:/producto/inicio";
	}
	
	@GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "producto/registro";
    }
	
	@PostMapping("/registrar-cuenta")
	public String procesarRegistro(@ModelAttribute Cliente cliente, RedirectAttributes flash) {
	    try {
	        cliente.setRol("CLIENTE"); 
	        cliente.setEstado("1");

	        clienteService.save(cliente); 
	        
	        flash.addFlashAttribute("toast", Alert.sweetToast("¡Cuenta creada con éxito! Ya puedes iniciar sesión.", "success", 5000));
	        return "redirect:/producto/inicio"; 
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	        flash.addFlashAttribute("error", "Ocurrió un error al registrar la cuenta. Verifica tus datos.");
	        return "redirect:/registro";
	    }
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/producto/inicio";
	}
}
