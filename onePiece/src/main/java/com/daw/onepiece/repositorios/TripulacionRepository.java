package com.daw.onepiece.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.entities.TripulacionEntity;

public interface TripulacionRepository extends CrudRepository<TripulacionEntity, Integer> {

    // 🔹 Listar tripulaciones con filtros y número de miembros actuales
    @Query("""
        SELECT new com.daw.onepiece.dtos.TripulacionDTO(
            t.id,
            t.nombre,
            t.barco,
            t.estaActiva,
            (SELECT COUNT(r) 
             FROM ReclutamientoEntity r 
             WHERE r.tripulacion.id = t.id AND r.esMiembroActual = true)
        )
        FROM TripulacionEntity t
        WHERE (:id IS NULL OR t.id = :id)
          AND (:nombre IS NULL OR LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
          AND (:barco IS NULL OR LOWER(t.barco) LIKE LOWER(CONCAT('%', :barco, '%')))
          AND (:estaActiva IS NULL OR t.estaActiva = :estaActiva)
        ORDER BY t.nombre
    """)
    List<TripulacionDTO> buscarTripulaciones(
        @Param("id") Integer id,
        @Param("nombre") String nombre,
        @Param("barco") String barco,
        @Param("activo") Integer estaActivo
    );

   

    // 🔹 Desactivar todos los reclutamientos activos de un pirata
    @Modifying
    @Transactional
    @Query("UPDATE ReclutamientoEntity r SET r.esMiembroActual = false WHERE r.pirata.id = :idPirata AND r.esMiembroActual = true")
    void desactivarReclutamientosDelPirata(@Param("idPirata") Integer idPirata);

}
