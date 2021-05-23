package com.dev.tiendamusicalentities.dto;

import com.dev.tiendamusicalentities.entities.Album;
import com.dev.tiendamusicalentities.entities.Artista;

public class ArtistaAlbumDTO {
	
	public ArtistaAlbumDTO() {
		super();
	}
	
	public ArtistaAlbumDTO(Album album, Artista artista) {
		this.album = album;
		this.artista = artista;
	}

	private Artista artista;
	
	private Album album;

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
