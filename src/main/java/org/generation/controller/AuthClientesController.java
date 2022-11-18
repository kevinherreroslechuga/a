package org.generation.controller;

import org.generation.entity.dto.*;
import org.generation.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins="*")
public class AuthClientesController {

	@Autowired
	IClientesService clientesService;	


	@PostMapping //localhost:8080/login
	@ResponseBody
	public ResponseEntity<?> loginCustomer(@RequestBody AuthClientes authCustomer) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<ClientesDto>(clientesService.findClientesByEmail(authCustomer), HttpStatus.ACCEPTED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
	
	
	
}
