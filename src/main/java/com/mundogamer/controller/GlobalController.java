package com.mundogamer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mundogamer.model.Cliente;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {

	@ModelAttribute("usuario")
    public Cliente agregarUsuarioGlobal(HttpSession session) {
		return (Cliente) session.getAttribute("usuario");
	}
}

/* Esto hace que en cualquier pagina este siempre iniciada la sesion, 
si no tendria que escribirlo en cada controller */