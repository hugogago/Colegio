package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.dtos.PirataDTO;

import com.daw.onepiece.servicio.interfaces.IPirataService;

@Service
public class PirataServiceImpl implements IPirataService {
	@Autowired
	IPirataDAO pirataDAO;
	
	@Override
	public ArrayList<PirataDTO> buscarPiratas(Integer id, String nombre, String fruta, Integer activo) {
       return pirataDAO.buscarPiratas(id, nombre, fruta, activo);
    }
	
	@Override
    public int insertarPirata(String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo) {
    	return pirataDAO.insertarPirata(nombre, frutaDelDiablo, isla, fecha, activo);
    }
	
	
	 @Override
	    public int actualizarPirata(Integer id, String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo) {
		 	return pirataDAO.actualizarPirata(id, nombre, frutaDelDiablo, isla, fecha, activo);
	    }

	    @Override
	    public int eliminarPirata(String id) {
	    	return pirataDAO.eliminarPirata(id);
	    }
	
}
