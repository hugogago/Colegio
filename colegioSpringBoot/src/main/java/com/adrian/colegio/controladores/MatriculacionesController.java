package com.adrian.colegio.controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.dtos.MatriculacionDTO;

import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.CajaRepository;
import com.adrian.colegio.repositorios.MatriculacionRepository;
import com.adrian.colegio.repositorios.NotaRepository;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@Controller
@RequestMapping("/matriculaciones")
public class MatriculacionesController {
	
	@Autowired
	IMatriculacionesService matriculacionesService;
	
	@Autowired
	MatriculacionRepository matriculacionRepository;
	
	@Autowired
	IDesplegablesDAO desplegables;
	
	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@Autowired
	CajaRepository cajaRepository;
	
	@GetMapping("/listadoMatriculaciones")
	public String formularioListadoMatriculaciones() {
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping("/listadoMatriculaciones")
	public String listadoMatriculaciones(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "idAsignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "tasa", required = false) Double tasa,
			@RequestParam(value = "fecha", required = false) String fecha, 
			@RequestParam(value = "activo", required = false) String activo, ModelMap model){
		
		
		int act = (activo != null) ? 1 : 0;
		String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

		ArrayList<MatriculacionDTO> listadoMatriculaciones = matriculacionesService.obtenerMatriculacionesPorFiltros(id,idAlumno, idAsignatura, 
				nombreAlumno, nombreAsignatura, fechaFiltrada, act, tasa);
		
		model.addAttribute("lista", listadoMatriculaciones);
		
		
		return "matriculaciones/listadoMatriculaciones";
	}
	
	
	@GetMapping("/insertarMatriculacion")
	public String formularioInsertarMatriculacion(ModelMap model) {
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		
		return "matriculaciones/insertarMatriculacion";
	
	}
	
	@PostMapping("/insertarMatriculacion")
	public String insertarMatriculaciones(@RequestParam(value = "alumno" , required = false) Integer idAlumno,
			@RequestParam(value = "asignatura" , required = false) Integer idAsignatura,
			@RequestParam(value = "tasa", required = false)Integer tasa,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) throws SQLException {
			
		
		
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			Integer resultado = matriculacionesService.insertarMatriculacion(idAsignatura, idAlumno, fechaFiltrada, tasa);
			
			model.addAttribute("resultado", resultado);
		
		
			return "matriculaciones/insertarMatriculacion";
		
	}
	
	
	@GetMapping(value = "formularioActualizarMatriculaciones")
	public String formualarioModificarMatriculaciones(ModelMap model) {
		return "matriculaciones/actualizarMatriculaciones";
	}
	
	
	@PostMapping(value = "/formularioActualizarMatriculaciones")
	public String formularioModificarMatriculaciones(
	        @RequestParam(value = "id", required = false) Integer id,
	        @RequestParam(value = "idAlumno", required = false) Integer idAlumno,
	        @RequestParam(value = "idAsignatura", required = false) Integer idAsignatura,
	        @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
	        @RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
	        @RequestParam(value = "tasa", required = false) Double tasa,
	        @RequestParam(value = "fecha", required = false) String fecha,
	        @RequestParam(value = "activo", required = false) String activo,
	        ModelMap model) {

	    ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
	    ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();

	    model.addAttribute("desplegableAlumnos", listaAlumnos);
	    model.addAttribute("desplegableAsignaturas", listaAsignaturas);

	    Integer act = (activo != null) ? 1 : null;
	    String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

	    ArrayList<MatriculacionDTO> listadoMatriculaciones =
	        matriculacionesService.obtenerMatriculacionesPorFiltros(
	            id, idAlumno, idAsignatura,
	            nombreAlumno, nombreAsignatura,
	            fechaFiltrada, act, tasa
	        );

	    model.addAttribute("lista", listadoMatriculaciones);

	    return "matriculaciones/actualizarMatriculaciones";
	}

	
	
	@PostMapping(value = "/actualizarMatriculacion")
	public String modificarMatriculaciones(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumno", required = false) Integer idAlumno,
			@RequestParam(value = "asignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "tasa", required = false) Float tasa,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) throws SQLException {
		
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			/*
			System.out.println("Matriculacion ID: " + id);
			System.out.println("Matriculacion alumno: " + idAlumno);
			System.out.println("Matriculacion asignatura: " + idAsignatura);
			System.out.println("Matriculacion tasa: " + tasa);
			System.out.println("Matriculacion fecha: " + fecha);
			*/
			
			Integer resultado = matriculacionesService.actualizarMatriculacion(id, idAsignatura, idAlumno, fechaFiltrada, tasa);
			
			model.addAttribute("resultado", resultado);
			
			return "matriculaciones/actualizarMatriculaciones";
	}
	
	
	@GetMapping(value = "/formularioBorrarMatriculaciones")
	public String getFormularioEliminarMatriculaciones() {
	    return "matriculaciones/borrarMatriculaciones";
	}
	
	
	@PostMapping(value = "/formularioBorrarMatriculaciones")
	public String formularioEliminarMatriculaciones(
	        @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
	        @RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
	        @RequestParam(value = "fecha", required = false) String fecha,
	        ModelMap model) {

	    // Si fecha está vacía, poner null
	    String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

	    ArrayList<MatriculacionDTO> listadoMatriculaciones =
	        matriculacionesService.obtenerMatriculacionesPorFiltros(
	            null, null, null,
	            nombreAlumno, nombreAsignatura,
	            fechaFiltrada, 1, null
	        );

	    model.addAttribute("lista", listadoMatriculaciones);

	    return "matriculaciones/borrarMatriculaciones";
	}


	
	@PostMapping(value = "/borrarMatriculacion")
	public String eliminarMatriculaciones(@RequestParam("id") String id, ModelMap model) throws SQLException {
		Integer resultado = matriculacionesService.borrarMatriculacion(id);
		
		model.addAttribute("resultado",resultado);
		return "matriculaciones/borrarMatriculaciones";
	}
	
	
	
	
}
