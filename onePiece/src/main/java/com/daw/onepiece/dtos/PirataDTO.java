package com.daw.onepiece.dtos;

public class PirataDTO {
	private Integer id;
	private String nombre;
	private String frutaDelDiablo;
	private String fecha;
	private int activo;
	
	private String isla;
	private Integer idIsla;
	
	private String tripulacion;
	private String rol;
	
	
	
	
	
	
	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, String fecha, int activo, String isla,
			Integer idIsla, String tripulacion, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fecha = fecha;
		this.activo = activo;
		this.isla = isla;
		this.idIsla = idIsla;
		this.tripulacion = tripulacion;
		this.rol = rol;
	}
	
	public PirataDTO() {
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
	public String getIsla() {
		return isla;
	}
	public void setIsla(String isla) {
		this.isla = isla;
	}
	public Integer getIdIsla() {
		return idIsla;
	}
	public void setIdIsla(Integer idIsla) {
		this.idIsla = idIsla;
	}
	public String getTripulacion() {
		return tripulacion;
	}
	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
