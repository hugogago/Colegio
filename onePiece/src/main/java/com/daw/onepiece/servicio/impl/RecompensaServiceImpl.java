package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;

@Service
public class RecompensaServiceImpl implements IRecompensaService{
	
	@Autowired
	IRecompensaDAO recompensaDAO;

	@Override
	public ArrayList<RecompensaDTO> listarTodasRecompensas() {
		
		return recompensaDAO.listarTodasRecompensas();
	}

	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasFiltradas(String nombrePirata, Integer idTripulacion,
			Long cantidadMin, Integer vigente) {
		
		return recompensaDAO.buscarRecompensasFiltradas(nombrePirata, idTripulacion, cantidadMin, vigente);
	}

	@Override
	public Integer emitirRecompensa(Integer idPirata, Long cantidad) {
		
		return recompensaDAO.emitirRecompensa(idPirata, cantidad);
	}

	@Override
	public int actualizarRecompensa(Integer id, Integer idPirata, Long cantidad, Integer vigente) {
		
		return recompensaDAO.actualizarRecompensa(id, idPirata, cantidad, vigente);
	}

	@Override
	public int marcarNoVigente(Integer id) {
		
		return recompensaDAO.marcarNoVigente(id);
	}

	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasParaActualizar(Integer id, String nombrePirata, Integer vigente) {
		
		return recompensaDAO.buscarRecompensasParaActualizar(id, nombrePirata, vigente);
	}

	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasParaBorrar(Integer id, String nombrePirata) {
		
		return recompensaDAO.buscarRecompensasParaBorrar(id, nombrePirata);
	}

}
