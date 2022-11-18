package org.generation.service;



import org.generation.entity.Ventas;
import org.generation.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasService {
	@Autowired
	VentasRepository ventasRepository;

	public Iterable<Ventas> getAllVentas(){
		return ventasRepository.findAll();
	}
	public Ventas saveVentas(Ventas Ventas) {
		return ventasRepository.save(Ventas);
	}
}
