package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Service
public class TripulacionServiceImpl implements ITripulacionService {
	
	@Autowired
	ITripulacionDAO tripulacionDAO;
	
	
	@Override
	public ArrayList<TripulacionDTO> buscarTripulaciones(Integer id, String nombre, String barco, Integer estaActiva){
		return tripulacionDAO.buscarTripulaciones(id, nombre, barco, estaActiva);
	}
	
	
	@Override
	public int insertarTripulacion(String nombre, String barco, Integer estaActiva) {
		return tripulacionDAO.insertarTripulacion(nombre, barco, estaActiva);
	}
	
	@Override
	public int actualizarTripulacion(String nombre, String barco, Integer estaActiva) {
		return tripulacionDAO.actualizarTripulacion(estaActiva, nombre, barco, estaActiva);
	}
	
	@Override
	public int eliminarTripulacion(String id) {
		return tripulacionDAO.eliminarTripulacion(id);
	}
}
