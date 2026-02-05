package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.entities.RecompensaEntity;
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.repositorios.RecompensaRepository;

import jakarta.transaction.Transactional;

@Repository
public class RecompensaDAOImpl implements IRecompensaDAO{
	
	@Autowired
	RecompensaRepository recompensaRepository;
	
	@Autowired
	PirataRepository pirataRepository;

	@Override
	public ArrayList<RecompensaDTO> listarTodasRecompensas() {
		return recompensaRepository.findAllRecompensas();
	}

	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasFiltradas(String nombrePirata, Integer idTripulacion,
			Long cantidadMin, Integer vigente) {
		return recompensaRepository.buscarRecompensasFiltradas(nombrePirata, idTripulacion, cantidadMin, vigente);
	}

	@Override
	@Transactional
	public Integer emitirRecompensa(Integer idPirata, Long cantidad) {
		recompensaRepository.desactivarRecompensasVigentesDePirata(idPirata);
		RecompensaEntity nueva = new RecompensaEntity();
		nueva.setPirata(pirataRepository.findById(idPirata).orElse(null));
		nueva.setCantidad(cantidad);
		nueva.setEstaVigente(1);
		recompensaRepository.save(nueva);
		return nueva.getId();
	}

	@Override
	@Transactional
	public int actualizarRecompensa(Integer id, Integer idPirata, Long cantidad, Integer vigente) {
		return recompensaRepository.actualizarRecompensa(id, cantidad, vigente);
	}

	@Override
	@Transactional
	public int marcarNoVigente(Integer id) {
		return recompensaRepository.marcarNoVigente(id);
	}
	
	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasParaActualizar(Integer id, String nombrePirata, Integer vigente) {
		return recompensaRepository.buscarRecompensasFiltradas(nombrePirata, null, null, vigente);
	}

	@Override
	public ArrayList<RecompensaDTO> buscarRecompensasParaBorrar(Integer id, String nombrePirata) {
		return recompensaRepository.buscarRecompensasFiltradas(nombrePirata, null, null, 1);
	}
	
}
