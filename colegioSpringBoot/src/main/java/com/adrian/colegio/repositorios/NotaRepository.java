package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.entities.NotaEntity;


public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{
	@Query("""
		    SELECT new com.adrian.colegio.dtos.NotaDTO(
		        n.id,
		        n.nota,
		        a.id,
		        a.nombre,
		        al.id,
		        al.nombre,
		        n.fecha
		    )
		    FROM NotaEntity n
		    JOIN n.asignatura a
		    JOIN n.alumno al
		    WHERE (:idAlumno IS NULL OR al.id = :idAlumno)
		    AND (:nota IS NULL OR n.nota = :nota)
		    AND (:nombreAlumno IS NULL OR LOWER(al.nombre) LIKE LOWER(CONCAT('%', :nombreAlumno, '%')))
		    AND (:nombreAsignatura IS NULL OR LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombreAsignatura, '%')))
		    AND (:fecha IS NULL OR n.fecha >= :fecha)
		    AND (:activo IS NULL OR al.activo = :activo)
		""")
		ArrayList<NotaDTO> buscarNotasPorFiltros(
		    @Param("idAlumno") Integer idAlumno,
		    @Param("nombreAlumno") String nombreAlumno,
		    @Param("nombreAsignatura") String nombreAsignatura,
		    @Param("nota") Float nota,
		    @Param("fecha") String fecha,
		    @Param("activo") int activo  
		);


	
	
	
}
