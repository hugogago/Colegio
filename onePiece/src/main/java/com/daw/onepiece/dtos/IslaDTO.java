package com.daw.onepiece.dtos;

public class IslaDTO {
	private Integer id;
	private String nombre;
	
	
	public IslaDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public IslaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
