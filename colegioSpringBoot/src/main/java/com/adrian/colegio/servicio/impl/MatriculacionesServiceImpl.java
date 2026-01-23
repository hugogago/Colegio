package com.adrian.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IMatriculacionesDAO;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@Service
public class MatriculacionesServiceImpl implements IMatriculacionesService{
	
	@Autowired
	IMatriculacionesDAO matriculacionesDAO;
	
	@Override
	public double calcularTasa(String idAlumno, Integer idAsignatura) {
		// TODO Auto-generated method stub
		return matriculacionesDAO.obtenerTasaAsignatura(idAsignatura);
	}

	@Override
	public int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Integer activo) throws SQLException {
		// TODO Auto-generated method stub
		return matriculacionesDAO.insertarMatriculacion(idAsignatura, idAlumno, fecha, activo);
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(Integer id,Integer idAlumno, Integer idAsignatura,String nombreAlumno, String nombreAsignatura,
			String fecha, Integer activo, Double tasa) {
		// TODO Auto-generated method stub
		return matriculacionesDAO.obtenerMatriculacionesPorFiltros(id, idAlumno, idAsignatura,nombreAlumno, nombreAsignatura, fecha, activo, tasa);
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
			String nombreAlumno, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Float tasa) throws SQLException {
		// TODO Auto-generated method stub
		return matriculacionesDAO.actualizarMatriculacion(id, idAsignatura, idAlumno, fecha, tasa);
	}

	@Override
	public int borrarMatriculacion(String id) throws SQLException {
		// TODO Auto-generated method stub
		return matriculacionesDAO.borrarMatriculacion(id);
	}

}
