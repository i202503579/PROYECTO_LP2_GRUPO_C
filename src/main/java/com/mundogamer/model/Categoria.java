package com.mundogamer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categorias")
@Getter
@Setter
public class Categoria {
	
	@Id
	@Column(name = "IdCategoria")
	private String idCategoria;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
}

