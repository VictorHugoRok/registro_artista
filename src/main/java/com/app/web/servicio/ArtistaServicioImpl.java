package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Artista;
import com.app.web.repositorio.ArtistaRepositorio;

@Service
public class ArtistaServicioImpl implements ArtistaServicio {

	@Autowired
	private ArtistaRepositorio repositorio;

	@Override
	public List<Artista> listarTodosArtistas() {

		return repositorio.findAll();
	}

	@Override
	public Artista guardarArtista(Artista artista) {
		return repositorio.save(artista);
	}

	@Override
	public Artista obtenerArtistaID(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Artista actualizarArtista(Artista artista) {
		return repositorio.save(artista);
	}


	@Override
	public void eliminarArtista(Long id) {
		if (repositorio.existsById(id)) {
			repositorio.deleteById(id);
		}
	}

	@Override
	public void eliminarArtistas(List<Long> ids) {
	    repositorio.deleteAllById(ids);
	}
	
	   @Override
	    public List<Artista> buscarPorNombre(String nombre) {
	        return repositorio.findByNombreContainingIgnoreCase(nombre);
	    }
	   @Override
	   public List<Artista> filtrarPorAlbumesMayorQue(int albumes) {
	       return repositorio.findByAlbumesGreaterThan(albumes);
	   }

	   @Override
	   public List<Artista> filtrarPorAlbumesMenorQue(int albumes) {
	       return repositorio.findByAlbumesLessThan(albumes);
	   }

	   @Override
	   public List<Artista> filtrarPorAlbumesIgualA(int albumes) {
	       return repositorio.findByAlbumes(albumes);
	   }
}
