package com.app.web.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Artista;

@Repository
public interface ArtistaRepositorio extends JpaRepository<Artista, Long>{
	List<Artista> findByNombreContainingIgnoreCase(String nombre);
	
	  List<Artista> findByAlbumesGreaterThan(int albumes);
	    List<Artista> findByAlbumesLessThan(int albumes);
	    List<Artista> findByAlbumes(int albumes);
}
