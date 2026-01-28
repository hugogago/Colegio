package com.daw.onepiece.dtos;

public class ReclutamientoDTO {

    private Integer id;
    private Integer idPirata;
    private String nombrePirata;
    private String rol;

    public ReclutamientoDTO(Integer id, Integer idPirata, String nombrePirata, String rol) {
        super();
        this.id = id;
        this.idPirata = idPirata;
        this.nombrePirata = nombrePirata;
        this.rol = rol;
    }

    public ReclutamientoDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPirata() {
        return idPirata;
    }

    public void setIdPirata(Integer idPirata) {
        this.idPirata = idPirata;
    }

    public String getNombrePirata() {
        return nombrePirata;
    }

    public void setNombrePirata(String nombrePirata) {
        this.nombrePirata = nombrePirata;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
