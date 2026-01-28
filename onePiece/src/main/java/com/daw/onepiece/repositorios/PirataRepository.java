package com.daw.onepiece.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.PirataEntity;

public interface PirataRepository extends CrudRepository<PirataEntity, Integer> {

    
    @Query("""
        SELECT new com.daw.onepiece.dtos.PirataDTO(
            p.id,
            p.nombre,
            p.frutaDelDiablo,
            p.fecha,
            p.activo,
            i.nombre,
            i.id,
            t.nombre,
            r.rol
        )
        FROM PirataEntity p
        LEFT JOIN p.isla i
        LEFT JOIN p.reclutamientos r
        LEFT JOIN r.tripulacion t
        WHERE (r.esMiembroActual = 1 OR r IS NULL)
          AND (:id IS NULL OR p.id = :id)
          AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
          AND (:fruta IS NULL OR LOWER(p.frutaDelDiablo) LIKE LOWER(CONCAT('%', :fruta, '%')))
          AND (:activo IS NULL OR p.activo = :activo)
        ORDER BY p.nombre
    """)
    List<PirataDTO> buscarPiratas(
        @Param("id") Integer id,
        @Param("nombre") String nombre,
        @Param("fruta") String fruta,
        @Param("activo") Integer activo
    );

   
    

}
