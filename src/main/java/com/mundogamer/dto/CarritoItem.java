package com.mundogamer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoItem {
	
	private Integer idJuego;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
}
