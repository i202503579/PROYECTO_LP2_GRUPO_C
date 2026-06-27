package com.mundogamer.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ventas")
@Getter
@Setter
public class Venta {
	
	@Id
	@Column(name = "IdVenta")
	private String idVenta;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@Column(name = "FechaVenta")
	private LocalDateTime fechaVenta;
	
	@Column(name = "MontoTotal")
	private Double montoTotal;
	
	@Column(name = "Estado")
	private String estado;
}

