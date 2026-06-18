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
@Table(name = "Mensaje")
@Getter
@Setter
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMensaje")
	private Integer idMensaje;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@Column(name = "TextoMensaje")
	private String mensaje;
	
	@Column(name = "FechaEnvio")
	private LocalDate fechaEnvio;
	
	@Column(name = "Estado")
	private String estado;
}

