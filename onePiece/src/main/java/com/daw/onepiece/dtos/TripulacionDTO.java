package com.daw.onepiece.dtos;

public class TripulacionDTO {

    private Integer id;
    private String nombre;
    private String barco;
    private boolean estaActiva;
    private int numeroMiembros;

    public TripulacionDTO(Integer id, String nombre, String barco, boolean estaActiva, int numeroMiembros) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.barco = barco;
        this.estaActiva = estaActiva;
        this.numeroMiembros = numeroMiembros;
    }

    public TripulacionDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarco() {
        return barco;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public int getNumeroMiembros() {
        return numeroMiembros;
    }

    public void setNumeroMiembros(int numeroMiembros) {
        this.numeroMiembros = numeroMiembros;
    }
}
