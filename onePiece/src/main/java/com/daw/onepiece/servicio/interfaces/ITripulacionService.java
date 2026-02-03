package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> buscarTripulaciones(Integer id, String nombre, String barco, Integer estaActiva);

	int insertarTripulacion(String nombre, String barco, Integer estaActiva);

	int actualizarTripulacion(String nombre, String barco, Integer estaActiva);

	int eliminarTripulacion(String id);
	
}
