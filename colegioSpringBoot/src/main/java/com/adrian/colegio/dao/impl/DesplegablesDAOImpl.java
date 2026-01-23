package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dtos.AlumnoDTO;
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.MunicipioEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.MunicipioRepository;

@Repository
public class DesplegablesDAOImpl implements IDesplegablesDAO {

	@Autowired // Inyectamos el repository
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		// Utilizamos el método que nos "regala" Spring data JPA
		Iterable<MunicipioEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		ArrayList<DesplegableDTO> listaMunicipios = mapeoEntidadMunicioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	private ArrayList<DesplegableDTO> mapeoEntidadMunicioComboDTO(Iterable<MunicipioEntity> listaEntidadesMunicipios) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (MunicipioEntity municipiosEntity : listaEntidadesMunicipios) {
			listaCombos.add(new DesplegableDTO(municipiosEntity.getIdMunicipio(), municipiosEntity.getNombre()));
		}
		return listaCombos;

	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumno = alumnoRepository.findAll();	
		ArrayList<DesplegableDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumno);
		
		return listaAlumnos;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity>listaEntidadesAlumno){
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AlumnoEntity alumnoEntity : listaEntidadesAlumno) {
			listaCombos.add(new DesplegableDTO(alumnoEntity.getId(), alumnoEntity.getNombre()));
		}
		return listaCombos;
		
	}
	
	
	

	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		Iterable<AsignaturaEntity> listaEntidadesAsignatura = asignaturaRepository.findAll();	
		ArrayList<DesplegableDTO> listaAsignaturas = mapeoEntidadAsignaturasComboDTO(listaEntidadesAsignatura);
		
		return listaAsignaturas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadAsignaturasComboDTO(Iterable<AsignaturaEntity>listaEntidadesAsignatura){
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AsignaturaEntity asignaturaEntity : listaEntidadesAsignatura) {
			listaCombos.add(new DesplegableDTO(asignaturaEntity.getId(), asignaturaEntity.getNombre()));
		}
		return listaCombos;
		
	}
	

}
