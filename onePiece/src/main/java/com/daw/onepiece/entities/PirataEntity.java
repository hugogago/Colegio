package com.daw.onepiece.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pirata")
public class PirataEntity {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@Column(name = "frutaDelDiablo")
	private String frutaDelDiablo;
	
	@Column(name = "fechaNacimiento")
	private String fecha;
	
	@Column(name = "estaActivo")
	private int activo;
	
	@ManyToOne
	@JoinColumn(name = "isla_id")
	private IslaEntity isla;
	
	
	@OneToMany(mappedBy = "pirata")
	private List<ReclutamientoEntity> reclutamientos;


	public PirataEntity(Integer id, String nombre, String frutaDelDiablo, String fecha, int activo, IslaEntity isla,
			List<ReclutamientoEntity> reclutamientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fecha = fecha;
		this.activo = activo;
		this.isla = isla;
		this.reclutamientos = reclutamientos;
	}
	
	public PirataEntity() {
		super();
	}


	public PirataEntity(String nombre, String frutaDelDiablo, IslaEntity isla, String fecha, int activo) {
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fecha = fecha;
		this.activo = activo;
		this.isla = isla;
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


	public String getFrutaDelDiablo() {
		return frutaDelDiablo;
	}


	public void setFrutaDelDiablo(String frutaDelDiablo) {
		this.frutaDelDiablo = frutaDelDiablo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}


	public IslaEntity getIdIsla() {
		return isla;
	}


	public void setIdIsla(IslaEntity isla) {
		this.isla = isla;
	}


	public List<ReclutamientoEntity> getReclutamientos() {
		return reclutamientos;
	}


	public void setReclutamientos(List<ReclutamientoEntity> reclutamientos) {
		this.reclutamientos = reclutamientos;
	}
	
	
	
	
}
