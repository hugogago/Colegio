package com.daw.onepiece.controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.repositorios.TripulacionRepository;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {
	
	@Autowired
	ITripulacionService tripulacionService;
	
	@Autowired
	TripulacionRepository tripulacionRepository;
	
	@GetMapping("/listadoTripulaciones")
	public String formularioListadoTripulaciones() {
		return "tripulaciones/listadoTripulaciones";
	}
	
	@PostMapping("/listadoTripulaciones")
	public String listadoTripulaciones(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model){
		
		
		
		String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
		String barcoNull = barco == null || barco.trim().isEmpty() ? null : barco.trim();
		Integer act = (activo != null) ? 1 : 0;
		System.out.println(id);
		
		

		ArrayList<TripulacionDTO> listadoTripulaciones = tripulacionService.buscarTripulaciones(id, nombreNull, barcoNull, act);
		
		model.addAttribute("lista", listadoTripulaciones);
		
		
		return "tripulaciones/listadoTripulaciones";
	}
	
	
	
	@GetMapping("/insertarTripulacion")
	public String formularioInsertarTripulaciones(ModelMap model) {
		return "tripulaciones/insertarTripulacion";
	
	}
	
	@PostMapping("/insertarTripulacion")
	public String insertarTripulacion(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model) throws SQLException {
			
		
		
			String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
			String barcoNull = barco == null || barco.trim().isEmpty() ? null : barco.trim();
			Integer act = (activo != null) ? 1 : 0;

			Integer resultado = tripulacionService.insertarTripulacion(nombreNull, barcoNull, act);
			
			model.addAttribute("resultado", resultado);
		
		
			return "tripulaciones/insertarTripulacion";
		
	}
	
	@GetMapping(value = "formularioActualizarTripulaciones")
	public String formualarioModificarTripulacion(ModelMap model) {
		return "tripulaciones/actualizarTripulaciones";
	}
	
	@PostMapping(value = "/formularioActualizarTripulaciones")
	public String formularioModificarTripulaciones(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model){
		
		
		
		String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
		String barcoNull = barco == null || barco.trim().isEmpty() ? null : barco.trim();
		Integer act = (activo != null) ? 1 : 0;
		
		
		

		ArrayList<TripulacionDTO> listadoTripulaciones = tripulacionService.buscarTripulaciones(id, nombreNull, barcoNull, act);
		
		model.addAttribute("lista", listadoTripulaciones);

	    return "tripulaciones/actualizarTripulaciones";
	}
	
	
	
	@PostMapping(value = "/actualizarTripulacion")
	public String modificarTripulaciones(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model) throws SQLException {
			
		
		
			String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
			String barcoNull = barco == null || barco.trim().isEmpty() ? null : barco.trim();
			Integer act = (activo != null) ? 1 : 0;
			
			System.out.println(act);
			
			Integer resultado = tripulacionService.actualizarTripulacion(nombreNull, barcoNull, act);
			
			model.addAttribute("resultado", resultado);
		
		
			return "tripulaciones/actualizarTripulaciones";
	}
	
	
	
	@GetMapping(value = "/formularioBorrarTripulaciones")
	public String getFormularioEliminarTripulaciones() {
	    return "tripulaciones/borrarTripulaciones";
	}
	
	@PostMapping(value = "/formularioBorrarTripulaciones")
	public String formularioBorrarTripulaciones(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model){
		
		
		
		String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
		String barcoNull = barco == null || barco.trim().isEmpty() ? null : barco.trim();
		Integer act = (activo != null) ? 1 : null;
		
		ArrayList<TripulacionDTO> listadoTripulaciones = tripulacionService.buscarTripulaciones(id, nombreNull, barcoNull, 1);

	    model.addAttribute("lista", listadoTripulaciones);

	    return "tripulaciones/borrarTripulaciones";
	}
	
	
	@PostMapping(value = "/borrarTripulacion")
	public String eliminarPiratas(@RequestParam("id") String id, ModelMap model) throws SQLException {
		Integer resultado = tripulacionService.eliminarTripulacion(id);
		
		model.addAttribute("resultado",resultado);
		return "tripulaciones/borrarTripulaciones";
	}
	
}
