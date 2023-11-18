package com.uce.edu.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String Nombre;
	private String Codigo;
	private Integer numeroCreditos;
	
	@Override
	public String toString() {
		return "Materia [Nombre=" + Nombre + ", Codigo=" + Codigo + ", numeroCreditos=" + numeroCreditos + "]";
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}
	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

}
