package org.generation.controller;



import org.generation.entity.Ventas;

import org.generation.service.VentasService;
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
@RequestMapping("/api/ventas")
@CrossOrigin(origins="*")
public class VentasController {

	@Autowired
	VentasService ventasService;
	
	@GetMapping
	  public @ResponseBody Iterable<Ventas> getAllVentas() {
	    return ventasService.getAllVentas();
	  }
	@PostMapping 
	@ResponseBody
	public ResponseEntity<?> addNewVentas(@RequestBody Ventas ventas) {
		try {
			
			return new ResponseEntity<Ventas>(ventasService.saveVentas(ventas), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
}
