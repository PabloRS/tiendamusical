package com.dev.tiendamusicalservices.service;

import java.util.List;

import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;

public interface HomeService {
	
	List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro);

}
