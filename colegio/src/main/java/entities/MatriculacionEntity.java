package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private AlumnoEntity alumno;
    
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private AsignaturasEntity asignatura;
    
    @Column(name = "fecha")
	private Integer fecha;
    
    @Column(name = "activo")
   	private Integer activo;
    
    
    @OneToOne(mappedBy = "matricula")
    private CajaEntity caja;

    
    
	public MatriculacionEntity(Integer id, AlumnoEntity alumno, AsignaturasEntity asignatura, Integer fecha,
			Integer activo, CajaEntity caja) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.fecha = fecha;
		this.activo = activo;
		this.caja = caja;
	}



	public MatriculacionEntity() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public AlumnoEntity getAlumno() {
		return alumno;
	}



	public void setAlumno(AlumnoEntity alumno) {
		this.alumno = alumno;
	}



	public AsignaturasEntity getAsignatura() {
		return asignatura;
	}



	public void setAsignatura(AsignaturasEntity asignatura) {
		this.asignatura = asignatura;
	}



	public Integer getFecha() {
		return fecha;
	}



	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}



	public Integer getActivo() {
		return activo;
	}



	public void setActivo(Integer activo) {
		this.activo = activo;
	}



	public CajaEntity getCaja() {
		return caja;
	}



	public void setCaja(CajaEntity caja) {
		this.caja = caja;
	}
    
    
}
