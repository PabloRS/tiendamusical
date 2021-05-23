package com.dev.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.file.CommonsUploadedFile;

import com.dev.tiendamusicalentities.entities.Persona;
import com.dev.tiendamusicalservices.service.LoginService;
import com.dev.tiendamusicalweb.session.SessionBean;
import com.dev.tiendamusicalweb.utils.CommonUtils;

@ManagedBean
@ViewScoped
public class LoginController {
	
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
