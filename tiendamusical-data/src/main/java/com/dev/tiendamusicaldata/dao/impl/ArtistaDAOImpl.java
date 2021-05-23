package com.dev.tiendamusicaldata.dao.impl;

import java.util.List;

import com.dev.tiendamusicaldata.common.CommonDAO;
import com.dev.tiendamusicaldata.dao.ArtistaDAO;
import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalentities.entities.Artista;

public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {
	
	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro) {
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
