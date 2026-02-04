package com.daw.onepiece.dtos;

public class MiembroTripulacionDTO {
	private int id;
	private String nombre;
	private String frutaDelDiablo;
	private String nombreTripulacion;
	private String fecha;
	private String isla;
	private int idIsla;
	private int estaActivo;
	private String rol;
	
	public MiembroTripulacionDTO(int id, String nombre, String frutaDelDiablo, String nombreTripulacion, String fecha,
			String isla, int idIsla, int estaActivo, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.nombreTripulacion = nombreTripulacion;
		this.fecha = fecha;
		this.isla = isla;
		this.idIsla = idIsla;
		this.estaActivo = estaActivo;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getNombreTripulacion() {
		return nombreTripulacion;
	}
	public void setNombreTripulacion(String nombreTripulacion) {
		this.nombreTripulacion = nombreTripulacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIsla() {
		return isla;
	}
	public void setIsla(String isla) {
		this.isla = isla;
	}
	public int getIdIsla() {
		return idIsla;
	}
	public void setIdIsla(int idIsla) {
		this.idIsla = idIsla;
	}
	public int getEstaActivo() {
		return estaActivo;
	}
	public void setEstaActivo(int estaActivo) {
		this.estaActivo = estaActivo;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
