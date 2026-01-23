package com.adrian.colegio.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja")
public class CajaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "idmatricula")
	private MatriculacionEntity matricula;
	
	@Column(name = "importe")
	private Float importe;
	
	

	public CajaEntity() {
		super();
	}



	public CajaEntity(MatriculacionEntity nuevaMatriculacion, double obtenerTasaAsignatura) {
		super();
		this.matricula = nuevaMatriculacion;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public MatriculacionEntity getMatricula() {
		return matricula;
	}



	public void setMatricula(MatriculacionEntity matricula) {
		this.matricula = matricula;
	}



	public Float getImporte() {
		return importe;
	}



	public void setImporte(Float importe) {
		this.importe = importe;
	}

}
