package com.adrian.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;



public interface IAsignaturaService {
	public ArrayList<AsignaturaDTO> obtenerAsignatura() throws SQLException;
	public  ArrayList<AsignaturaDTO> obtenerAsignaturaPorId(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
	public int borrarAsignatura(Integer id);
	int insertarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
	int actualizarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
}
