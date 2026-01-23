package com.adrian.colegio.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.MatriculacionDTO;



public interface IMatriculacionesDAO {
	

	

	

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura, String nombreAlumno,
			int activo);
	

	int borrarMatriculacion(String id) throws SQLException;

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(Integer id, Integer idAlumno, Integer idAsignatura,
			String nombreAlumno, String nombreAsignatura, String fecha, Integer activo, Double tasa);
	
	double obtenerTasaAsignatura(Integer idAsignatura);

	int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Integer activo) throws SQLException;

	Integer actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Float tasa) throws SQLException;
}
