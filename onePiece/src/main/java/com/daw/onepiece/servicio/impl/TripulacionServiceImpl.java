package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.MiembroTripulacionDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

import jakarta.transaction.Transactional;

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
	public int actualizarTripulacion(Integer id,String nombre, String barco, Integer estaActiva) {
		return tripulacionDAO.actualizarTripulacion(id, nombre, barco, estaActiva);
	}
	
	@Override
	public int eliminarTripulacion(String id) {
		return tripulacionDAO.eliminarTripulacion(id);
	}
	
	@Override
	public ArrayList<MiembroTripulacionDTO> obtenerPiratasActivosDeTripulacion(Integer idTripulacion){
		return tripulacionDAO.obtenerPiratasActivosDeTripulacion(idTripulacion);
	}


	@Override
	public TripulacionDTO obtenerTripulacionPorId(Integer id) {
		
		return tripulacionDAO.obtenerTripulacionPorId(id);
	}


	@Override
	@Transactional
	public void eliminarMiembro(Integer idPirata, Integer idTripulacion) {
		tripulacionDAO.eliminarMiembro(idPirata, idTripulacion);
		
	}


	@Override
	public int desactivarTripulacion(Integer id) {
		
		return tripulacionDAO.desactivarTripulacion(id);
	}


	@Override
	@Transactional
	public void agregarMiembro(Integer idPirata, Integer idTripulacion, String rol) {
		tripulacionDAO.agregarMiembro(idPirata, idTripulacion, rol);
		
	}


	
}
