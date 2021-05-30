package com.dev.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.tiendamusicalentities.entities.CarritoAlbum;
import com.dev.tiendamusicalservices.service.CarritoService;
import com.dev.tiendamusicalweb.session.SessionBean;

@ManagedBean
@ViewScoped
public class CarritoController {
	
	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;

	@PostConstruct
	public void init() {
		this.calcularTotal();
	}
	
	public void calcularTotal() {
		LOGGER.info("Calculando total");
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(total);
	}
	
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		LOGGER.info("Eliminando album " + carritoAlbum.getAlbum().getNombre() + " del carrito");
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		this.calcularTotal();
	}
	
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantitdad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(totalCompra);
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}

	
	
}
