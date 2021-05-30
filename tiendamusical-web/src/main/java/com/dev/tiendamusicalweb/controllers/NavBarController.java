package com.dev.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.tiendamusicalweb.utils.CommonUtils;

@ManagedBean
@ViewScoped
public class NavBarController {
	
	private static final Logger LOGGER = LogManager.getLogger(NavBarController.class);
	
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando pantalla carrito");
	}
	
	public void redireccionar() {
		try {
			CommonUtils.redireccionar("/pages/cliente/carrito.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Error al ingresar al carrito");
			e.printStackTrace();
		}
	}

}
