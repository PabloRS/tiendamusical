package com.dev.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dev.tiendamusicalentities.entities.Persona;

public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long>{
	
	@Query("SELECT p FROM Persona p WHERE p.usuario = ?1 AND p.password = ?2")
	Persona findByUsuarioAndPassword(String usuario, String password);

}
