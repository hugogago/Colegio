package com.adrian.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IAsignaturasDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturaService;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {
	
	@Autowired
	IAsignaturasDAO asignaturaDAO;

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignatura() throws SQLException {
		// TODO Auto-generated method stub
		return asignaturaDAO.obtenerAsignatura();
	}

	@Override
	public int borrarAsignatura(Integer id) {
		// TODO Auto-generated method stub
		return asignaturaDAO.borrarAsignatura(id);
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturaPorId (Integer id, String nombre, Integer curso, Float tasa,
			Integer activo) {
		// TODO Auto-generated method stub
		return asignaturaDAO.obtenerAsignaturaPorId(id, nombre, curso, tasa, activo);
	}

	@Override
	public int insertarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo) {
		// TODO Auto-generated method stub
		return asignaturaDAO.insertarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int actualizarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo) {
		// TODO Auto-generated method stub
		return asignaturaDAO.actualizarAsignatura(id, nombre, curso, tasa, activo);
	}

}
