package com.dev.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalentities.entities.CarritoAlbum;
import com.dev.tiendamusicalservices.service.CarritoService;
import com.dev.tiendamusicalweb.session.SessionBean;

@ManagedBean
@ViewScoped
public class DetalleController {
	
	private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);
	
	private int cantidadAlbum;
	
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@PostConstruct
	public void init() {
		this.cantidadAlbum = 1;
	}
	
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando album al carrito de compras..." + this.cantidadAlbum);
		CarritoAlbum agregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), cantidadAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(agregado);
	}

	public int getCantidadAlbum() {
		return cantidadAlbum;
	}

	public void setCantidadAlbum(int cantidadAlbum) {
		this.cantidadAlbum = cantidadAlbum;
	}

	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	

}
