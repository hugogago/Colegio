package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;

public interface MatriculacionRepository extends CrudRepository<MatriculacionEntity, Integer> {
	@Query("""
			SELECT new com.adrian.colegio.dtos.MatriculacionDTO(
			m.id,
			a.id,
			a.nombre,
			al.id,
			al.nombre,
			m.fecha,
			m.activo,
			a.tasa
			)
			FROM MatriculacionEntity m
			JOIN m.asignatura a
			JOIN m.alumno al
			WHERE (:id IS NULL OR m.id = :id)
			AND (:idAlumno IS NULL OR al.id = :idAlumno)
			AND (:idAsignatura IS NULL OR a.id = :idAsignatura)
			AND (:nombreAlumno IS NULL OR LOWER(al.nombre) LIKE LOWER(CONCAT('%', :nombreAlumno, '%')))
			AND (:nombreAsignatura IS NULL OR LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombreAsignatura, '%')))
			AND (:fecha IS NULL OR m.fecha = :fecha)
			AND (:activo IS NULL OR m.activo = :activo)
			AND (:tasa IS NULL OR a.tasa = :tasa)
			""")
	ArrayList<MatriculacionDTO> buscarMatriculacionesAvanzado(@Param("id") Integer id,
			@Param("idAlumno") Integer idAlumno, @Param("idAsignatura") Integer idAsignatura,
			@Param("nombreAlumno") String nombreAlumno, @Param("nombreAsignatura") String nombreAsignatura,
			@Param("fecha") String fecha, @Param("activo") Integer activo, @Param("tasa") Double tasa);
}
