package com.dev.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.tiendamusicaldata.dao.CarritoAlbumDAO;
import com.dev.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.dev.tiendamusicalentities.entities.Carrito;
import com.dev.tiendamusicalentities.entities.CarritoAlbum;
import com.dev.tiendamusicalservices.service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	private CarritoAlbumDAO carritoAlbumDao;
	
	@Override
	public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbum) {
		CarritoAlbum carritoAlbum = new CarritoAlbum();
		carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbum);
		carritoAlbum.setEstatus("PENDIENTE");
		return this.carritoAlbumDao.save(carritoAlbum);
	}
	
	@Override
	public float calcularTotal(Carrito carrito) {
		float total = 0.0f;
		
		for(CarritoAlbum carritoAlbum: carrito.getCarritosAlbum()) {
			total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
		}
		
		return total;
	}

	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		this.carritoAlbumDao.delete(carritoAlbum);
	}

	@Override
	public float actualizarAlbumCantitdad(CarritoAlbum carritoAlbum, Carrito carrito) {
		
		this.carritoAlbumDao.save(carritoAlbum);
		return this.calcularTotal(carrito);
	}

}
