package org.generation.service;



import org.generation.entity.Productos;

import org.generation.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
	@Autowired
	ProductosRepository productosRepository;
	
	public Iterable<Productos> getAllProductos(){
		return productosRepository.findAll();
	}
	public Productos saveProductos(Productos productos) {
		return productosRepository.save(productos);
	}
	
}
