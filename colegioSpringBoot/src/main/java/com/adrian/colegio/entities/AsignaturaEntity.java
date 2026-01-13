package com.adrian.colegio.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;


import jakarta.persistence.Column;


@Entity
@Table(name = "asignaturas")
public class AsignaturaEntity {
	
	public AsignaturaEntity(Integer id, String nombre, Integer curso, Float tasa, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
	}

	public AsignaturaEntity() {
		super();
	}
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "curso")
	private Integer curso;
	
	@Column(name = "tasa")
	private Float tasa;
	
	@Column(name = "activo")
	private Integer activo;

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

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Float getTasa() {
		return tasa;
	}

	public void setTasa(Float tasa) {
		this.tasa = tasa;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
	
	

}
