package com.dev.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalentities.entities.Persona;

@ManagedBean
@SessionScoped
public class SessionBean {

	private Persona persona;
	private ArtistaAlbumDTO artistaAlbumDTO;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando sesion");
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}
	
	
}
