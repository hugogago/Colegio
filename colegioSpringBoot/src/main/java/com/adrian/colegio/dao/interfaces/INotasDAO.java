package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.NotaDTO;



public interface INotasDAO {
	 ArrayList<NotaDTO> obtenerTodasNotas();

	   

	    ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
	            String nota, int activo);

	    

	    

	    int borrarNota(String id);



		int insertarNota(Integer idAlumno, Integer idAsignatura, Float nota, String fecha);


		int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Float nota, String fecha);


		ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura, Float nota,
				String fecha, int activo);



		



		



		
}
