package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="artistas")

public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable = false,length = 50)
	private String nombre;
	
	@Column(name="albumes", nullable = false)
	private int albumes;
	
	@Column(name="email",nullable = false,length = 50, unique=true)
	private String email;
	
	
	
	public Artista() {
		
	}


	public Artista(Long id, String nombre, int albumes, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.albumes = albumes;
		this.email = email;
	}
	
	public Artista( String nombre, int albumes, String email) {
		super();
		this.nombre = nombre;
		this.albumes = albumes;
		this.email = email;
	}
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getAlbumes() {
		return albumes;
	}



	public void setAlbumes(int albumes) {
		this.albumes = albumes;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", albumes=" + albumes + ", email=" + email + "]";
	}
	
	
	


}
