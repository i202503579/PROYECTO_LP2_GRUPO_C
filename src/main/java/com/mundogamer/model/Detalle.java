package com.mundogamer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle")
@IdClass(DetalleId.class)
@Getter
@Setter
public class Detalle {
	
	@Id	
	@ManyToOne
	@JoinColumn(name = "IdVenta")
	private Venta venta;

	@Id
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

