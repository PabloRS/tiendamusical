package com.dev.tiendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.tiendamusicalentities.entities.CarritoAlbum;
import com.dev.tiendamusicalentities.entities.Persona;
import com.dev.tiendamusicalservices.service.LoginService;
import com.dev.tiendamusicalweb.session.SessionBean;
import com.dev.tiendamusicalweb.utils.CommonUtils;

@ManagedBean
@ViewScoped
public class LoginController {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
	private String usuario;
	
	private String password;
	
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginServiceImpl;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	@PostConstruct
	public void init() {
		System.out.println("Inicializando login");
	}
	
	public void entrar() {
		Persona persona = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);	
		if(persona != null) {
			try {
				List<CarritoAlbum> carritoAlbum = persona.getCarrito().getCarritosAlbum()
					.stream()
					.filter(ca -> ca.getEstatus().equals("PENDIENTE"))
					.collect(Collectors.toList());
				
				persona.getCarrito().setCarritosAlbum(carritoAlbum);
				
				LOGGER.info("Albums filtrados");
				
				this.sessionBean.setPersona(persona);
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Formato incorrecto");
			}
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Usuario y/o contraseña incorrecto");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	

}
