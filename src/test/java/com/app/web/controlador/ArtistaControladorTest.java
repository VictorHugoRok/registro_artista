package com.app.web.controlador;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.web.entidad.Artista;
import com.app.web.servicio.ArtistaServicio;

@ExtendWith(MockitoExtension.class)
public class ArtistaControladorTest {

    @Mock
    private ArtistaServicio servicio;

    @InjectMocks
    private ArtistaControlador controlador;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controlador).build();
    }

    @Test
    public void testGuardarArtista() throws Exception {
        Artista artista = new Artista();
        artista.setNombre("Artista 1");
        artista.setEmail("artista1@example.com");
        artista.setAlbumes(5);

        when(servicio.guardarArtista(any(Artista.class))).thenReturn(artista);

        mockMvc.perform(post("/artistas")
                .flashAttr("artista", artista))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artistas"));

        verify(servicio, times(1)).guardarArtista(any(Artista.class));
    }

    @Test
    public void testEliminarArtista() throws Exception {
        Long id = 1L;

        doNothing().when(servicio).eliminarArtista(id);

        mockMvc.perform(get("/artistas/eliminar/{id}", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artistas"));

        verify(servicio, times(1)).eliminarArtista(id);
    }

    @Test
    public void testEliminarMultiplesArtistas() throws Exception {
        List<Long> artistasIds = Arrays.asList(1L, 2L, 3L);

        doNothing().when(servicio).eliminarArtistas(artistasIds);

        mockMvc.perform(post("/artistas/eliminar-multiples")
                .param("artistasIds", "1", "2", "3"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artistas"));

        verify(servicio, times(1)).eliminarArtistas(artistasIds);
    }
}