package com.dev.tiendamusicalservices.service;

import com.dev.tiendamusicalentities.entities.Persona;

public interface LoginService {

	Persona consultarUsuarioLogin(String usuario, String password);
}
