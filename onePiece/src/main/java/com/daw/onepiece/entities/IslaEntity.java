package com.daw.onepiece.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "isla")
public class IslaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "isla")
    private List<PirataEntity> listaPiratas = new ArrayList<>();

	public IslaEntity(Integer id, String nombre, List<PirataEntity> listaPiratas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaPiratas = listaPiratas;
	}
	
	public IslaEntity() {
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

	public List<PirataEntity> getListaPiratas() {
		return listaPiratas;
	}

	public void setListaPiratas(List<PirataEntity> listaPiratas) {
		this.listaPiratas = listaPiratas;
	}
    
    
   
}
