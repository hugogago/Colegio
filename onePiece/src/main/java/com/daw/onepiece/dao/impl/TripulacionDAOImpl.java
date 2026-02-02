package com.daw.onepiece.dao.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.repositorios.TripulacionRepository;


public class TripulacionDAOImpl implements ITripulacionDAO {
	
	 @Autowired
	 private TripulacionRepository tripulacionRepository;
	 
	 
	 @Override
	 public ArrayList<TripulacionDTO> buscarTripulaciones(Integer id,String nombre, String barco, Integer estaActivo ){
		 return new ArrayList<>(
				 tripulacionRepository.buscarTripulaciones(id, nombre, barco, estaActivo));
				 
	 }

}
