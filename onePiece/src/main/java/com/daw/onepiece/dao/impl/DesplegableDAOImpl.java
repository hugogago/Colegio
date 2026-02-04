package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PirataRepository;

@Repository
public class DesplegableDAOImpl implements IDesplegablesDAO {
	@Autowired
	private IslaRepository islaRepository;
	
	@Autowired
	private PirataRepository pirataRepository;
	
	
	
	@Override
	public ArrayList<DesplegableDTO> desplegableIslas(){
		Iterable<IslaEntity> listaEntidadesIslas = islaRepository.findAll();
		ArrayList<DesplegableDTO> listaIslas = mapeoEntidadesIslasComboDTO(listaEntidadesIslas);
		return listaIslas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadesIslasComboDTO(Iterable<IslaEntity> listaEntidadesIslas){
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for(IslaEntity islaEntity : listaEntidadesIslas) {
			listaCombos.add(new DesplegableDTO(islaEntity.getId(), islaEntity.getNombre()));
		}
		return listaCombos;
	}
	
	
	@Override
	public ArrayList<DesplegableDTO> desplegablePiratas(){
		Iterable<PirataEntity> listaEntidadesPiratas = pirataRepository.findAll();
		ArrayList<DesplegableDTO> listaPiratas = mapeoEntidadesPiratasComboDTO(listaEntidadesPiratas);
		return listaPiratas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadesPiratasComboDTO(Iterable<PirataEntity> listaEntidadesPiratas){
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for(PirataEntity pirataEntity : listaEntidadesPiratas) {
			listaCombos.add(new DesplegableDTO(pirataEntity.getId(), pirataEntity.getNombre()));
		}
		return listaCombos;
	}
	
	
	
	
}
