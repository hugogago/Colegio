package com.daw.onepiece.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tripulacion")
public class TripulacionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "barco")
    private String barco;
    
    @Column(name = "estaActiva")
    private Integer estaActiva;
    
    
    @OneToMany(mappedBy = "tripulacion")
	private List<ReclutamientoEntity> listaReclutamientos = new ArrayList<>();


	public TripulacionEntity(Integer id, String nombre, String barco, Integer estaActiva,
			List<ReclutamientoEntity> listaReclutamientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.estaActiva = estaActiva;
		this.listaReclutamientos = listaReclutamientos;
	}
	
	public TripulacionEntity() {
		super();
	}


	public TripulacionEntity(String nombre, String barco, Integer estaActiva) {
		this.nombre = nombre;
		this.barco = barco;
		this.estaActiva = estaActiva;
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


	public String getBarco() {
		return barco;
	}


	public void setBarco(String barco) {
		this.barco = barco;
	}


	public Integer getEstaActiva() {
		return estaActiva;
	}


	public void setEstaActiva(Integer estaActiva) {
		this.estaActiva = estaActiva;
	}


	public List<ReclutamientoEntity> getListaReclutamientos() {
		return listaReclutamientos;
	}


	public void setListaReclutamientos(List<ReclutamientoEntity> listaReclutamientos) {
		this.listaReclutamientos = listaReclutamientos;
	}
    
    

    
}
