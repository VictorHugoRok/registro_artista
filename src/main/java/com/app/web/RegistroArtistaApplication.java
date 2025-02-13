package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Artista;
import com.app.web.repositorio.ArtistaRepositorio;

@SpringBootApplication
public class RegistroArtistaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RegistroArtistaApplication.class, args);
	}
	
	@Autowired
	private ArtistaRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
