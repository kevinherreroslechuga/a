package org.generation.controller;


import org.generation.entity.DetalleVenta;


import org.generation.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalleVenta")
@CrossOrigin(origins="*")
public class DetalleVentaController {
	@Autowired
	DetalleVentaService detalleVentaService;

	@GetMapping//localhost:8080/api/detalleVenta
	  public @ResponseBody Iterable<DetalleVenta> getAllDetalleVenta() {
	    return detalleVentaService.getAllDetalleVenta();
	}
	
	@PostMapping 
	@ResponseBody
	public ResponseEntity<?> addNewDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
		try {
			
			return new ResponseEntity<DetalleVenta>(detalleVentaService.saveDetalleVenta(detalleVenta), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}

	
	
}
