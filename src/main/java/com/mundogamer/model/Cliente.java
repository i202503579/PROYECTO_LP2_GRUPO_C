package com.mundogamer.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Clientes")
@Getter
@Setter
public class Cliente {
	
	@Id
	@Column(name = "IdCliente")
	private String idCliente;
	
	@Column(name = "Apellidos")
	private String apellidos;
	
	@Column(name = "Nombres")
	private String nombres;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "Direccion")
	private String direccion;
	
	@Column(name = "Telefono")
	private String telefono;
	
	@Column(name = "FechaNacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "Sexo")
	private String sexo;
	
	@Column(name = "Correo")
	private String correo;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Estado")
	private String estado;
}

