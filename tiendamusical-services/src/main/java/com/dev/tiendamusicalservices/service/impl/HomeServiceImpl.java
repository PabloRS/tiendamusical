package com.dev.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.tiendamusicaldata.dao.ArtistaDAO;
import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalservices.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private ArtistaDAO artistaDAOImpl;

	@Override
	public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
		return artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
