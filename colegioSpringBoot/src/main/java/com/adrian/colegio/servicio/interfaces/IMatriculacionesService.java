package com.adrian.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.MatriculacionDTO;



public interface IMatriculacionesService {
	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura, String nombreAlumno,
			int activo);

	

	int borrarMatriculacion(String id) throws SQLException;

	double calcularTasa(String idAlumno, Integer idAsignatura);

	

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(Integer id, Integer idAlumno, Integer idAsignatura,
			String nombreAlumno, String nombreAsignatura, String fecha, Integer activo, Double tasa);

	



	int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Integer tasa) throws SQLException;



	Integer actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fechaFiltrada,
			Float tasa) throws SQLException;

}
