package com.adrian.colegio.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dtos.AlumnoDTO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.servicio.interfaces.IAsignaturaService;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

	@Autowired
	IAsignaturaService asignaturaService;
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	
	@GetMapping("/insertarAsignatura")
	public String formularioListadoAsignatura(ModelMap model) {
		
		return "asignaturas/insertarAsignatura";
	}
	
	@PostMapping("/insertarAsignatura")
	public String insertarAsignatura(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Float tasa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model){
		
		
		Integer act = activo != null ? 1 : 0;
		Integer resultado = asignaturaService.insertarAsignatura(id, nombre, curso, tasa, act);
		
		model.addAttribute("resultado", resultado);
		
		
		
		return "asignaturas/insertarAsignatura";
		
	}
	
	@GetMapping("/listadoAsignaturas")
	public String formularioListadoAsignaturas() {
		return "asignaturas/listadoAsignaturas";
	}

	@PostMapping("/listadoAsignaturas")
	public String listadoAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Float tasa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {

		
		Integer act = (activo != null) ? 1 : 0;

		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturaPorId(id, nombre, curso,
				tasa, act);

		model.addAttribute("lista", listaAsignaturas);

		return "asignaturas/listadoAsignaturas";
	}
	
	
	
	
	@GetMapping("/formularioActualizarAsignaturas")
	public String formularioModificarAsignatura(ModelMap model) {
		
		return "asignaturas/actualizarAsignaturas";
	}
	
	
	//Método que se encarga de la búsqueda de alumnos para actualizar
		@PostMapping(value = "/formularioActualizarAsignaturas")
		public String formularioModificarAsignatura(@RequestParam(value = "id", required = false) Integer id,
		                                         @RequestParam(value = "nombre", required = false) String nombre,
		                                         @RequestParam(value = "curso", required = false) Integer curso,
		                                         @RequestParam(value = "tasa", required = false) Float tasa,
		                                         @RequestParam(value = "activo", required = false) String activo,
		                                         ModelMap model) {
		    
			
			
			
		    Integer act = activo != null ? 1 : 0;

		    ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturaPorId(id, nombre, curso, tasa, act);

		    model.addAttribute("lista", listaAsignaturas);
		    return "asignaturas/actualizarAsignaturas";
		}
		
		
		
		@PostMapping(value = "/actualizarAsignatura")
		public String modificarAsignatura(@RequestParam("id") Integer id, 
		                               @RequestParam("nombre") String nombre,
		                               @RequestParam(value = "curso", required = false) Integer curso,
		                               @RequestParam(value = "tasa", required = false) Float tasa,
		                               @RequestParam(value = "activo", required = false) Integer activo,
		                               ModelMap model) {
		    

			

		    
		    Integer act = activo != null ? 1 : 0;

		    Integer resultado = asignaturaService.actualizarAsignatura(id, nombre, curso, tasa, act);

		    model.addAttribute("resultado", resultado);
		    return "asignaturas/actualizarAsignaturas";
		}
		
		
		@GetMapping(value = "/formularioBorrarAsignaturas")
		public String getFormularioEliminarAsignaturas() {
		    return "asignaturas/borrarAsignaturas";
		}
		
		//Método que se usa para buscar los registros a borrar
		@PostMapping(value = "/formularioBorrarAsignaturas")
		public String formularioEliminarAsignaturas(@RequestParam(value= "id", required = false) Integer id, 
		                                        @RequestParam("nombre") String nombre,
		                                        @RequestParam(value = "curso", required = false) Integer curso,
		                                        @RequestParam(value = "tasa", required = false) Float tasa,
		                                        @RequestParam(value = "activo", required = false) Integer activo, 
		                                        ModelMap model) {
		    
		    
		    Integer act = activo != null ? 1 : 0;

		    ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturaPorId(id, nombre, curso, tasa, act);

		    model.addAttribute("lista", listaAsignaturas);
		    return "asignaturas/borrarAsignaturas";
		}
		
		@PostMapping(value = "/borrarAsignaturas")
		public String eliminarAlumnos(@RequestParam("id") Integer id, ModelMap model) {
		    Integer resultado = asignaturaService.borrarAsignatura(id);

		    model.addAttribute("resultado", resultado);
		    return "asignaturas/borrarAsignaturas";
		}
}
