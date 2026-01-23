package com.adrian.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.NotaDTO;



public interface INotasService {
	  public ArrayList<NotaDTO> obtenerNotas() throws SQLException;


	    public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
	            String nota, int activo);

	    

	    

	    public int borrarNota(String id);



		int insertarNota(Integer idAlumno, Integer idAsignatura, Float nota, String fecha);


		


		int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Float nota, String fecha);


		ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura, Float nota,
				String fecha, int activo);


		
}
