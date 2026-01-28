package com.daw.onepiece.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reclutamiento")
public class ReclutamientoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rol")
    private String rol;

    @Column(name = "esMiembroActual")
    private boolean esMiembroActual;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private PirataEntity pirata;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private TripulacionEntity tripulacion;

	public ReclutamientoEntity(Integer id, String rol, boolean esMiembroActual, PirataEntity pirata,
			TripulacionEntity tripulacion) {
		super();
		this.id = id;
		this.rol = rol;
		this.esMiembroActual = esMiembroActual;
		this.pirata = pirata;
		this.tripulacion = tripulacion;
	}

    

	public ReclutamientoEntity() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	public boolean isEsMiembroActual() {
		return esMiembroActual;
	}



	public void setEsMiembroActual(boolean esMiembroActual) {
		this.esMiembroActual = esMiembroActual;
	}



	public PirataEntity getPirata() {
		return pirata;
	}



	public void setPirata(PirataEntity pirata) {
		this.pirata = pirata;
	}



	public TripulacionEntity getTripulacion() {
		return tripulacion;
	}



	public void setTripulacion(TripulacionEntity tripulacion) {
		this.tripulacion = tripulacion;
	}
	
	
}
