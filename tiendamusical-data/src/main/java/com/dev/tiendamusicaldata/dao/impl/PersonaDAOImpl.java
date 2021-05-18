package com.dev.tiendamusicaldata.dao.impl;

import com.dev.tiendamusicaldata.common.CommonDAO;
import com.dev.tiendamusicaldata.dao.PersonaDAO;
import com.dev.tiendamusicalentities.entities.Persona;

public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	
	public Persona findByUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
	
	public Persona guardar(Persona persona) {
		return this.repository.save(persona);
	}
	
	public Persona actualizar(Persona persona) {
		return this.repository.save(persona);
	}
	
	public void eliminar(Persona persona) {
		this.repository.delete(persona);
	}

}
