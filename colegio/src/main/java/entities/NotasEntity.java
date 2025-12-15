package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "notas")
public class NotasEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nota")
    private String nota;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_alumnos")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignaturas")
    private AsignaturasEntity asignatura;
    
   

    public NotasEntity() {}

    public NotasEntity(AlumnoEntity alumno, AsignaturasEntity asignatura, String nota, String fecha) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
        this.fecha = fecha;
    }

    public NotasEntity(int id, AlumnoEntity alumno, AsignaturasEntity asignatura, String nota, String fecha) {
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
        this.fecha = fecha;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

    
}



	
