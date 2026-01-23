package com.adrian.colegio.controladores;

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
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.NotaRepository;
import com.adrian.colegio.servicio.interfaces.INotasService;

@Controller
@RequestMapping("/notas")
public class NotaController {
	@Autowired
	INotasService notasService;
	
	@Autowired
	IDesplegablesDAO desplegables;
	
	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@GetMapping("/listadoNotas")
	public String formularioListadoNotas() {
		return "notas/listadoNotas";
	}
	
	@PostMapping("/listadoNotas")
	public String listadoAsignaturas(@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Float Nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			@RequestParam(value = "activo", required = false) String activo, ModelMap model){
		
		
		int act = (activo != null) ? 1 : 0;
		String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

		ArrayList<NotaDTO> listadoNotas = notasService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, Nota, 
				fechaFiltrada, act);
		
		model.addAttribute("lista", listadoNotas);
		
		
		return "notas/listadoNotas";
	}
	
	
	@GetMapping("/insertarNota")
	public String formularioInsertarNota(ModelMap model) {
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		
		return "notas/insertarNota";
	
	}
	
	
	@PostMapping("/insertarNota")
	public String insertarNota(@RequestParam(value = "alumno" , required = false) Integer idAlumno,
			@RequestParam(value = "asignatura" , required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false)Float nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
			
		
		
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			Integer resultado = notasService.insertarNota(idAlumno, idAsignatura, nota, fechaFiltrada);
			
			model.addAttribute("resultado", resultado);
		
		
			return "notas/insertarNota";
		
	}
	
	
	
	@GetMapping(value = "formularioActualizarNotas")
	public String formualarioModificarNotas(ModelMap model) {
		return "notas/actualizarNotas";
	}
	
	
	@PostMapping(value = "/formularioActualizarNotas")
	public String formularioModificarNotas(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombreAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "asignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false) Float nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {
			
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			Integer act = activo != null ? 1 : 0;
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			
			ArrayList<NotaDTO> listaNotas = notasService.obtenerNotasPorFiltros(idAlumno, fecha, id, nota, fechaFiltrada, act);
			
			model.addAttribute("lista", listaNotas);
			
			return "notas/actualizarNotas";
	}
	
	@PostMapping(value = "/actualizarNota")
	public String modificarNotas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumno", required = false) Integer idAlumno,
			@RequestParam(value = "asignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false) Float nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			
			Integer resultado = notasService.actualizarNota(id, idAlumno, idAsignatura, nota, fechaFiltrada);
			
			model.addAttribute(resultado);
			
			return "notas/actualizarNotas";
	}
	
	@GetMapping(value = "/formularioBorrarNotas")
	public String getFormularioEliminarNotas() {
	    return "notas/borrarNotas";
	}
	
	@PostMapping(value = "/formularioBorrarNotas")
	public String formularioEliminarNotas(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombreAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "asignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false) Float nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {
			
			ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			
			model.addAttribute("desplegableAlumnos", listaAlumnos);
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);
			
			Integer act = activo != null ? 1 : 0;
			String fechaFiltrada = (fecha != null && !fecha.isEmpty()) ? fecha : null;

			
			ArrayList<NotaDTO> listaNotas = notasService.obtenerNotasPorFiltros(idAlumno, activo, id, nota, fechaFiltrada, act);
			
			model.addAttribute("lista",listaNotas);
			
			return "notas/borrarNotas";
			
	}
	
	
	@PostMapping(value = "/borrarNota")
	public String eliminarNotas(@RequestParam("id") String id, ModelMap model) {
		Integer resultado = notasService.borrarNota(id);
		
		model.addAttribute(resultado);
		return "notas/borrarNotas";
	}
					
					
		
	
	
}
