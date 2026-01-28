package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;


public interface IPirataDAO {

	ArrayList<PirataDTO> buscarPiratas(Integer id, String nombre, String fruta, Integer activo);

	int insertarPirata(String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo);
	

	int eliminarPirata(String id);

	int actualizarPirata(Integer id, String nombre, String frutaDelDiablo, Integer isla, String fecha, int activo);

}
