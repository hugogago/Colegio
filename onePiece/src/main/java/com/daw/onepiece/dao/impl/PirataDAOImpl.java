package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PirataRepository;

@Repository
public class PirataDAOImpl implements IPirataDAO {

    @Autowired
    private PirataRepository pirataRepository;
    
    @Autowired
    private IslaRepository islaRepository;

    @Override
    public ArrayList<PirataDTO> buscarPiratas(Integer id, String nombre, String fruta, Integer activo) {
        return new ArrayList<>(
            pirataRepository.buscarPiratas(id, nombre, fruta, activo)
        );
    }
    
    @Override
    public int insertarPirata(String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo) {
    	IslaEntity idIsla = islaRepository.findById(isla).get();
    	
    	PirataEntity pirata = new PirataEntity(nombre, frutaDelDiablo, idIsla, fecha, activo);
    	pirataRepository.save(pirata);
    	return pirata.getId();
    }


    @Override
    public int actualizarPirata(Integer id, String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo) {

        PirataEntity pirata = pirataRepository.findById(id).orElse(null);
        if (pirata == null) return -1;

        IslaEntity idIsla = islaRepository.findById(isla).orElse(null);

        pirata.setNombre(nombre);
        pirata.setFrutaDelDiablo(
            (frutaDelDiablo == null || frutaDelDiablo.isEmpty()) ? null : frutaDelDiablo
        );
        pirata.setIdIsla(idIsla);
        pirata.setFecha(fecha);
        pirata.setActivo(activo);

        pirataRepository.save(pirata);

        return pirata.getId();
    }

    @Override
    public int eliminarPirata(String id) {
    	PirataEntity pirata = pirataRepository.findById(Integer.parseInt(id)).get();
    	
    	pirata.setActivo(0);
       pirataRepository.delete(pirata);
       return pirata.getId();
    }


}
