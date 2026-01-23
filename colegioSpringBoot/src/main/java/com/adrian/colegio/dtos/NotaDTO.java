package com.adrian.colegio.dtos;

public class NotaDTO {
	  private int id;
	    private Float nota;
	    private Integer idAsignatura;
	    private String nombreAsignatura;
	    private Integer idAlumno;
	    private String nombreAlumno;
	    private String fecha;

	    // Constructor completo
	    public NotaDTO(int id, Float nota, Integer idAsignatura, String nombreAsignatura, Integer idAlumno, String nombreAlumno,
	            String fecha) {
	        super();
	        this.id = id;
	        this.nota = nota;
	        this.idAsignatura = idAsignatura;
	        this.nombreAsignatura = nombreAsignatura;
	        this.idAlumno = idAlumno;
	        this.nombreAlumno = nombreAlumno;
	        this.fecha = fecha;
	    }

	    // Constructor sin nombres (para inserción)
	    public NotaDTO(int id, Float nota, Integer idAsignatura, Integer idAlumno, String fecha) {
	        super();
	        this.id = id;
	        this.nota = nota;
	        this.idAsignatura = idAsignatura;
	        this.idAlumno = idAlumno;
	        this.fecha = fecha;
	    }

	    // Constructor mínimo
	    public NotaDTO(int id, Float nota) {
	        super();
	        this.id = id;
	        this.nota = nota;
	    }

	    // Getters y setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Float getNota() {
	        return nota;
	    }

	    public void setNota(Float nota) {
	        this.nota = nota;
	    }

	    public Integer getIdAsignatura() {
	        return idAsignatura;
	    }

	    public void setIdAsignatura(Integer idAsignatura) {
	        this.idAsignatura = idAsignatura;
	    }

	    public String getNombreAsignatura() {
	        return nombreAsignatura;
	    }

	    public void setNombreAsignatura(String nombreAsignatura) {
	        this.nombreAsignatura = nombreAsignatura;
	    }

	    public Integer getIdAlumno() {
	        return idAlumno;
	    }

	    public void setIdAlumno(Integer idAlumno) {
	        this.idAlumno = idAlumno;
	    }

	    public String getNombreAlumno() {
	        return nombreAlumno;
	    }

	    public void setNombreAlumno(String nombreAlumno) {
	        this.nombreAlumno = nombreAlumno;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }
}
