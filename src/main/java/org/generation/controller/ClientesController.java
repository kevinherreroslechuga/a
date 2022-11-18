package org.generation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.generation.service.IClientesService;

import org.generation.entity.*;
import org.generation.entity.dto.ClientesDto;


@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins="*")
public class ClientesController {
	@Autowired
	IClientesService clientesService;	

	@GetMapping //localhost:8080/api/clientes
	@ResponseBody 
	//ResponseEntity configura la respuesta http
	public ResponseEntity<?> getAllClientes() {	
		try {
		return new ResponseEntity<Iterable<ClientesDto>>
			(clientesService.findAllClientes(), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/{id}") //localhost:8080/api/clientes/id
	@ResponseBody
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<ClientesDto>( 
					clientesService.convertClientesToDto(
							clientesService.findClientesById(id)
							),
					HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping //localhost:8080/api/clientes
	@ResponseBody
	public ResponseEntity<?> addNewCustomer(@RequestBody Clientes clientes) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<ClientesDto>(clientesService.saveClientes(clientes), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateClientes(@RequestBody Clientes clientes) {	
		try {
			
			return new ResponseEntity<ClientesDto>(clientesService.updateClientes(clientes), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}			
	}
	
	@DeleteMapping("/{id}") //localhost:8080/api/customer/id
	@ResponseBody
	public ResponseEntity<?> deleteClientes(@PathVariable("id") Long id) {
		try {			
			return new ResponseEntity<String>(clientesService.deleteClientesById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	
	}
	
	
}