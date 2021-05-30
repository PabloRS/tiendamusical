package com.dev.tiendamusicalservices.service;

import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalentities.entities.Carrito;
import com.dev.tiendamusicalentities.entities.CarritoAlbum;

public interface CarritoService {
	
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbum);
	
	float calcularTotal(Carrito carrito);
	
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	float actualizarAlbumCantitdad(CarritoAlbum carritoAlbum, Carrito carrito);

}
