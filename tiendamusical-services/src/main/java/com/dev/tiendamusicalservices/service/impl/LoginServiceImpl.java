package com.dev.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.tiendamusicaldata.dao.PersonaDAO;
import com.dev.tiendamusicalentities.entities.Persona;
import com.dev.tiendamusicalservices.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private PersonaDAO personaDAOImpl;

	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		return this.personaDAOImpl.findByUsuarioAndPassword(usuario, password);
	}

}
