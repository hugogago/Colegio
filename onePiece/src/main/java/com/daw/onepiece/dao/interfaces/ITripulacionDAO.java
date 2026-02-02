package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionDAO {

	ArrayList<TripulacionDTO> buscarTripulaciones(Integer id, String nombre, String barco, Integer estaActivo);

}
