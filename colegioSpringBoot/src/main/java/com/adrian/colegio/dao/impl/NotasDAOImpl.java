package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.INotasDAO;
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.NotaEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.NotaRepository;

@Repository
public class NotasDAOImpl implements INotasDAO {
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	NotaRepository notaRepository;
	
	@Override
	public ArrayList<NotaDTO> obtenerTodasNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
			String nota, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int borrarNota(String id) {
		NotaEntity nota = notaRepository.findById(Integer.parseInt(id)).get();
		notaRepository.delete(nota);
		
		return nota.getId();
	}



	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura,
			Float nota, String fecha, int activo) {
		
		return notaRepository.buscarNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, activo);
	}



	@Override
	public int insertarNota(Integer idAlumno, Integer idAsignatura, Float nota, String fecha) {

	    if (idAlumno == null || idAsignatura == null) {
	        return 0;
	    }

	    AlumnoEntity alumno = alumnoRepository.findById(idAlumno).orElse(null);
	    AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).orElse(null);

	    if (alumno == null || asignatura == null) {
	        return 0;
	    }

	    NotaEntity notas = new NotaEntity(alumno, asignatura, nota, fecha);
	    notaRepository.save(notas);

	    return notas.getId();
	}




	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Float nota, String fecha) {
		if (id == null || idAlumno == null || idAsignatura == null) {
		    return 0;
		}

		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).orElse(null);
		AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).orElse(null);

		if (alumno == null || asignatura == null) {
		    return 0;
		}

		NotaEntity notas = new NotaEntity(id, alumno, asignatura, nota, fecha);
		notaRepository.save(notas);

		return notas.getId();

	}

}
