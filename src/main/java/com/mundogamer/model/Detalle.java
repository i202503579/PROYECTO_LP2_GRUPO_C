package com.mundogamer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle")
@Getter
@Setter
public class Detalle {
	
	@Id
	@Column(name = "IdDetalle")
	private Integer detalle;
	
	@ManyToOne
	@JoinColumn(name = "IdVenta")
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "IdJuegos")
	private Juego juego;
	
	@Column(name = "Cantidad")
	private Integer cantidad;
	
	@Column(name = "Precio")
	private Double precio;
	
	@Column(name = "Estado")
	private String estado;
}

