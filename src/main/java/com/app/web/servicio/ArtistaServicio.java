package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Artista;

public interface ArtistaServicio {

	public List<Artista> listarTodosArtistas();

	public Artista guardarArtista(Artista artista);

	public Artista obtenerArtistaID(Long id);

	public Artista actualizarArtista(Artista artista);

	public void eliminarArtista(Long id);

	public void eliminarArtistas(List<Long> ids);

	public List<Artista> buscarPorNombre(String nombre);
	
    public List<Artista> filtrarPorAlbumesMayorQue(int albumes);
    public List<Artista> filtrarPorAlbumesMenorQue(int albumes);
    public List<Artista> filtrarPorAlbumesIgualA(int albumes);

}
