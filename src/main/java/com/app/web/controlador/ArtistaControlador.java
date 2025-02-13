package com.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Artista;
import com.app.web.servicio.ArtistaServicio;

@Controller
public class ArtistaControlador {

	@Autowired
	private ArtistaServicio servicio;

	@GetMapping({ "/artistas", "/" })
	public String listarArtistas(
	    @RequestParam(value = "albumesMayorQue", required = false) Integer albumesMayorQue,
	    @RequestParam(value = "albumesMenorQue", required = false) Integer albumesMenorQue,
	    @RequestParam(value = "albumesIgualA", required = false) Integer albumesIgualA,
	    Model modelo) {

	    if (albumesMayorQue != null) {
	        modelo.addAttribute("artistas", servicio.filtrarPorAlbumesMayorQue(albumesMayorQue));
	    } else if (albumesMenorQue != null) {
	        modelo.addAttribute("artistas", servicio.filtrarPorAlbumesMenorQue(albumesMenorQue));
	    } else if (albumesIgualA != null) {
	        modelo.addAttribute("artistas", servicio.filtrarPorAlbumesIgualA(albumesIgualA));
	    } else {
	        modelo.addAttribute("artistas", servicio.listarTodosArtistas());
	    }

	    return "artistas";
	}

	@GetMapping("/artistas/nuevo")
	public String mostrarFormRegistro(Model modelo) {
		Artista artista = new Artista();
		modelo.addAttribute("artista", artista);
		return "crear_artista";
	}

	@PostMapping("/artistas")
	public String guardarArtista(@ModelAttribute("artista") Artista artista) {
		servicio.guardarArtista(artista);
		return "redirect:/artistas";
	}

	@GetMapping("/artistas/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("artista", servicio.obtenerArtistaID(id));
		return "editar_artista";
	}

	@PostMapping("/artistas/{id}")
	public String actualizarArtista(@PathVariable Long id, @ModelAttribute("artista") Artista artista, Model modelo) {
		Artista artistaExistente = servicio.obtenerArtistaID(id);
		artistaExistente.setId(id);
		artistaExistente.setNombre(artista.getNombre());
		artistaExistente.setEmail(artista.getEmail());
		artistaExistente.setAlbumes(artista.getAlbumes());

		servicio.actualizarArtista(artistaExistente);

		return "redirect:/artistas";
	}

	@GetMapping("/artistas/eliminar/{id}")
	public String eliminarArtista(@PathVariable Long id) {
		servicio.eliminarArtista(id);
		return "redirect:/artistas";
	}

	@PostMapping("/artistas/eliminar-multiples")
	public String eliminarMultiples(@RequestParam("artistasIds") List<Long> artistasIds) {
		if (artistasIds != null && !artistasIds.isEmpty()) {
			servicio.eliminarArtistas(artistasIds);
		}
		return "redirect:/artistas";
	}


}
