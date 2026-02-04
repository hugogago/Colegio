package com.daw.onepiece.dao.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.MiembroTripulacionDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.entities.TripulacionEntity;
import com.daw.onepiece.repositorios.ReclutamientoRepository;
import com.daw.onepiece.repositorios.TripulacionRepository;

@Repository
public class TripulacionDAOImpl implements ITripulacionDAO {
	
	 @Autowired
	 private TripulacionRepository tripulacionRepository;
	 
	 @Autowired
	 private ReclutamientoRepository reclutamientoRepository;
	 
	 
	 @Override
	 public ArrayList<TripulacionDTO> buscarTripulaciones(Integer id,String nombre, String barco, Integer estaActiva ){
		 return new ArrayList<>(
				 tripulacionRepository.buscarTripulaciones(id, nombre, barco, estaActiva));
				 
	 }
	 
	 @Override 
	 public int insertarTripulacion(String nombre, String barco, Integer estaActiva) {
		 TripulacionEntity tripulacion = new TripulacionEntity(nombre, barco, estaActiva);
		 tripulacionRepository.save(tripulacion);
		 return tripulacion.getId();
	 }
	 
	 
	 @Override 
	 public int actualizarTripulacion(Integer id, String nombre, String barco, Integer estaActiva) {
		 TripulacionEntity tripulacion = tripulacionRepository.findById(id).orElse(null);
		 
		 if (tripulacion == null) return -1;
		 
		 tripulacion.setNombre(nombre);
		 tripulacion.setBarco(barco);
		 tripulacion.setEstaActiva(estaActiva);
		 System.out.println(tripulacion.getEstaActiva());
		 
		 tripulacionRepository.save(tripulacion);
		 
		 return tripulacion.getId();
	 }
	 
	 @Override
	 public int eliminarTripulacion (String id) {
		 TripulacionEntity tripulacion = tripulacionRepository.findById(Integer.parseInt(id)).get();
		 
		 tripulacion.setEstaActiva(0);
		 tripulacionRepository.save(tripulacion);
		 return tripulacion.getId();
	 }
	 
	 
	 @Override
	 public ArrayList<MiembroTripulacionDTO> obtenerPiratasActivosDeTripulacion(Integer idTripulacion) {
		return reclutamientoRepository.obtenerPiratasActivosDeTripulacion(idTripulacion);
	 }
	 

}
