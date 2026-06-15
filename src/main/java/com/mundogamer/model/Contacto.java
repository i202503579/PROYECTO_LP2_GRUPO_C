package com.mundogamer.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Contactos")
@Getter
@Setter
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdContacto")
	private Integer idContacto;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Telefono")
	private String telefono;
	
	@Column(name = "Mensaje")
	private String mensaje;
	
	@Column(name = "FechaEnvio")
	private LocalDate fechaEnvio;
	
	@Column(name = "Estado")
	private String estado;
}

