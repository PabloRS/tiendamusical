package com.dev.tiendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalservices.service.HomeService;
import com.dev.tiendamusicalweb.session.SessionBean;
import com.dev.tiendamusicalweb.utils.CommonUtils;

@ManagedBean
@ViewScoped
public class HomeController {
	
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

	private String filtro;
	
	private List<ArtistaAlbumDTO> artistasAlbumDTO;
	
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@PostConstruct
	public void init() {
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
		
	}
	
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if(this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach(artistaAlbum -> {
				LOGGER.info("Artista: " + artistaAlbum.getArtista().getNombre());
			});
		}
	}
	
	public void verDetalleAlbum(ArtistaAlbumDTO artistaAlbumDTO) {
		this.sessionBean.setArtistaAlbumDTO(artistaAlbumDTO);
		try {
			CommonUtils.redireccionar("/pages/cliente/detalle.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Error al redireccional al detalle del cliente");
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}

	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}

	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}

	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	
	
}
