package com.adrian.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.INotasDAO;
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;

@Service
public class NotasServiceImpl implements INotasService {
	@Autowired
	INotasDAO notasDAO;
	@Override
	public ArrayList<NotaDTO> obtenerNotas() throws SQLException {
		// TODO Auto-generated method stub
		return notasDAO.obtenerTodasNotas();
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura,
			Float nota, String fecha, int activo) {
		return notasDAO.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, activo);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
			String nota, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarNota(Integer idAlumno, Integer idAsignatura, Float nota, String fecha) {
		
		return notasDAO.insertarNota(idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Float nota, String fecha) {
		// TODO Auto-generated method stub
		return notasDAO.actualizarNota(id, idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int borrarNota(String id) {
		// TODO Auto-generated method stub
		return notasDAO.borrarNota(id);
	}

}
