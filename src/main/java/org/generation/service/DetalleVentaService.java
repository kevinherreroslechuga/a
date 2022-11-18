package org.generation.service;


import org.generation.entity.DetalleVenta;
import org.generation.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService  {
	@Autowired
	DetalleVentaRepository detalleVentaRepository;
	
	public Iterable<DetalleVenta> getAllDetalleVenta(){
		return detalleVentaRepository.findAll();
	}
	
	public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
		return detalleVentaRepository.save(detalleVenta);
	}
}
