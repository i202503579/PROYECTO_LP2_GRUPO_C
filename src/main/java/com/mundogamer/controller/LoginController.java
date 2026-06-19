package com.mundogamer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mundogamer.dto.AutenticacionFilter;
import com.mundogamer.model.Cliente;
import com.mundogamer.service.AutenticacionService;
import com.mundogamer.util.Alert;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final AutenticacionService autenticacionService;

	@PostMapping("/login")
	public String procesarLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes flash) {

		AutenticacionFilter filter = new AutenticacionFilter();
		filter.setEmail(email);
		filter.setPassword(password);

		Cliente cliente = autenticacionService.autenticar(filter);

		if (cliente == null) {
			flash.addFlashAttribute("error", "Correo o contraseña incorrectos");
			return "redirect:/producto/inicio";
		}

		session.setAttribute("usuario", cliente);

		flash.addFlashAttribute("toast",
				Alert.sweetToast("¡Bienvenido " + cliente.getNombres() + "!", "success", 5000));
		return "redirect:/producto/inicio";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/producto/inicio";
	}
}
