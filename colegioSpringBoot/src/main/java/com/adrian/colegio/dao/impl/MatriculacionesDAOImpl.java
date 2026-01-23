package com.adrian.colegio.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IMatriculacionesDAO;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.CajaEntity;
import com.adrian.colegio.entities.MatriculacionEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.CajaRepository;
import com.adrian.colegio.repositorios.MatriculacionRepository;

import jakarta.transaction.Transactional;

@Repository
public class MatriculacionesDAOImpl implements IMatriculacionesDAO {
	@Autowired
	MatriculacionRepository matriculacionRepository;

	@Autowired
	AlumnoRepository alumnoRepository;

	@Autowired
	AsignaturaRepository asignaturaRepository;

	@Autowired
	CajaRepository repoCaja;

	@Override
	public double obtenerTasaAsignatura(Integer idAsignatura) {
		AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();

		return asignatura.getTasa();
	}

	@Override
	public int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Integer activo)
			throws SQLException {
		AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();
		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();

		MatriculacionEntity nuevaMatriculacion = new MatriculacionEntity(asignatura, alumno, fecha, activo);
		matriculacionRepository.save(nuevaMatriculacion);

		CajaEntity caja = new CajaEntity(nuevaMatriculacion, obtenerTasaAsignatura(idAsignatura));

		repoCaja.save(caja);

		return nuevaMatriculacion.getId();
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(Integer id, Integer idAlumno,
			Integer idAsignatura, String nombreAlumno, String nombreAsignatura, String fecha, Integer activo,
			Double tasa) {

		return matriculacionRepository.buscarMatriculacionesAvanzado(id, idAlumno, idAsignatura, nombreAlumno,
				nombreAsignatura, fecha, activo, tasa);
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
			String nombreAlumno, int activo) {

		return null;
	}

	@Transactional
	public Integer actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Float tasa)
			throws SQLException {

		if (id == null || idAlumno == null || idAsignatura == null) {
			return 0;
		}

		MatriculacionEntity matriculacion = matriculacionRepository.findById(id).orElse(null);
		if (matriculacion == null) {
			return 0;
		}

		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).orElse(null);
		AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).orElse(null);

		if (alumno == null || asignatura == null) {
			return 0;
		}

		CajaEntity cajaAMod = repoCaja.findByMatricula(matriculacion);
		System.out.println("Tasa de la caja a modificar: " + cajaAMod.getImporte());
		if (cajaAMod != null) {
			Float tasaAntigua = matriculacion.getAsignatura().getTasa();
			System.out.print("Tasa antigua" + tasaAntigua + "\n");
			if (cajaAMod.getImporte() != tasaAntigua) {
				cajaAMod.setImporte(tasa);
				System.out.print("nueva tasa" + tasa + "\n");
				repoCaja.save(cajaAMod);

			}

		}

		matriculacion.setAlumno(alumno);
		matriculacion.setAsignatura(asignatura);
		matriculacion.setFecha(fecha);
		matriculacion.setCaja(cajaAMod);
		matriculacionRepository.save(matriculacion);

		return matriculacion.getId();
	}

	@Transactional
	@Override
	public int borrarMatriculacion(String id) {
		if (id == null || id.trim().isEmpty()) {
			throw new IllegalArgumentException("ID de matrícula es obligatorio");
		}

		int idInt = Integer.parseInt(id);

		MatriculacionEntity matriculacion = matriculacionRepository.findById(idInt)
				.orElseThrow(() -> new IllegalArgumentException("Matrícula no encontrada: " + id));

		CajaEntity caja = repoCaja.findByMatricula(matriculacion);
		if (caja != null) {
			repoCaja.delete(caja);
		}

		matriculacionRepository.delete(matriculacion);

		return idInt;
	}

}
