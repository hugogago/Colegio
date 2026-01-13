package com.adrian.colegio.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasDAO {
	public ArrayList<AsignaturaDTO> obtenerAsignatura() throws SQLException;
	public  ArrayList<AsignaturaDTO> obtenerAsignaturaPorId(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
	public int insertarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
	public int actualizarAsignatura(Integer id, String nombre, Integer curso, Float tasa, Integer activo);
	public int borrarAsignatura(Integer id);

}
