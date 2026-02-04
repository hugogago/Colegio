package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.MiembroTripulacionDTO;
import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> buscarTripulaciones(Integer id, String nombre, String barco, Integer estaActiva);

	int insertarTripulacion(String nombre, String barco, Integer estaActiva);

	int actualizarTripulacion(String nombre, String barco, Integer estaActiva);

	int eliminarTripulacion(String id);

	ArrayList<MiembroTripulacionDTO> obtenerPiratasActivosDeTripulacion(Integer idTripulacion);
	
	TripulacionDTO obtenerTripulacionPorId(Integer id);

	void eliminarMiembro(Integer idPirata, Integer idTripulacion);

	int desactivarTripulacion(Integer id);

	void agregarMiembro(Integer idPirata, Integer idTripulacion, String rol);
	
}
