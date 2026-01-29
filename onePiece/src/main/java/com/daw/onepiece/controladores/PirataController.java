package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.servicio.interfaces.IPirataService;

@Controller
@RequestMapping("/piratas")
public class PirataController {
	
	@Autowired
	IPirataService pirataService;
	
	@Autowired
	PirataRepository pirataRepository;
	
	@Autowired
	IDesplegablesDAO desplegables;
	
	
	
	
	@GetMapping("/listadoPiratas")
	public String formularioListadoPiratas() {
		return "piratas/listadoPiratas";
	}
	
	
	@PostMapping("/listadoPiratas")
	public String listadoMatriculaciones(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "frutaDiablo", required = false) String fruta,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model){
		
		
		
		String nombreNull = nombre == null || nombre.trim().isEmpty() ? null : nombre.trim();
		String frutaNull = fruta == null || fruta.trim().isEmpty() ? null : fruta.trim();
		int act = (activo != null) ? 1 : 0;
		System.out.println(id);
		System.out.println(nombreNull);
		System.out.println(frutaNull);
		System.out.println(act);
		

		ArrayList<PirataDTO> listadoPiratas = pirataService.buscarPiratas(id, nombreNull, frutaNull, act);
		
		model.addAttribute("lista", listadoPiratas);
		
		
		return "piratas/listadoPiratas";
	}
}
