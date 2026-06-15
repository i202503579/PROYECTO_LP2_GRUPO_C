package com.mundogamer.model;

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
@Table(name = "Juegos")
@Getter
@Setter
public class Juego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdJuegos")
	private Integer idJuegos;
	
	@ManyToOne
	@JoinColumn(name = "IdCategoria")
	private Categoria categoria;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Precio")
	private Double precio;
	
	@Column(name = "Imagen")
	private String imagen;
}

