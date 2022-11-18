package org.generation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.generation.entity.*;
import org.generation.entity.dto.AuthClientes;
import org.generation.entity.dto.ClientesDto;

import java.util.ArrayList;
import java.util.List;

import org.generation.repository.*;

@Service
public class ClientesService implements IClientesService {
	
	@Autowired
	ClientesRepository clientesRepository;

	@Override
	public List<ClientesDto> findAllClientes() throws Exception {		
//		List<Customer> customers = (List<Customer>) customerRepository.findAll();			
		//List<Customer> customers = (List<Customer>) customerRepository.findByIsActive(true);
		//List<Customer> customers = (List<Customer>) customerRepository.findByIsActiveOrderByLastNameAsc(true);
		List<Clientes> clientes = (List<Clientes>) clientesRepository.findBySocioActivoOrderByApellidoAsc(true);
		return convertAllClientesToDto(clientes);
	}

	@Override
	public Clientes findClientesById(Long id) throws Exception {		
		Clientes clientes = clientesRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalStateException
				("The user with id " + id + " does not exist"));
		if(!clientes.getSocio_activo())
			throw new IllegalStateException("The user with id " + id + " does not exist");
			return clientes;
	}

	@Override
	public ClientesDto findClientesByEmail(AuthClientes authClientes) {
		Clientes clientes =  clientesRepository.findByEmail(authClientes.getUsername())
				.orElseThrow(() ->
				new IllegalStateException
				("The email " + authClientes.getUsername() + " does not exists"));
		if (!clientes.getContrasena().equals(authClientes.getContrasena()))
			throw new IllegalStateException("Wrong password");
			
		return convertClientesToDto(clientes);
	}
	
	@Override
	public boolean existsClientesById(Long id) {
		return clientesRepository.existsById(id);
	}

	@Override
	public boolean existsClientesByEmail(String email) {
		return clientesRepository.existsByEmail(email);
	}

	@Override
	public ClientesDto saveClientes(Clientes clientes) throws Exception {					
		if (!(clientes.getNombre().length() < Clientes.NOMBRE_MAX_LENGTH))			
			throw new IllegalStateException("Name length is greater than "+ Clientes.NOMBRE_MAX_LENGTH);
		else if(!(clientes.getApellido().length() < Clientes.APELLIDO_MAX_LENGTH))			
			throw new IllegalStateException("Lastname length is greater than "+ Clientes.APELLIDO_MAX_LENGTH);
				
		clientes.setSocio_activo(true);
		return convertClientesToDto(clientesRepository.save(clientes));		
	}
	
	@Override
	public ClientesDto updateClientes(Clientes clientes) throws Exception {			
		Clientes clientesInDatabase = findClientesById(clientes.getIdCliente());		
		clientesInDatabase.setNombre(clientes.getNombre());
		clientesInDatabase.setApellido(clientes.getApellido());
		clientesInDatabase.setMovil(clientes.getMovil());
		clientesInDatabase.setDireccion(clientes.getDireccion());
		clientesInDatabase.setSocio_activo(true);				
		return saveClientes(clientesInDatabase);	
	}
	
	@Override
	public String deleteClientesById(Long id) throws Exception {
		Clientes clientesInDatabase = findClientesById(id);
		clientesInDatabase.setSocio_activo(false);		
		clientesRepository.save(clientesInDatabase);
		return "El Miembro ha sido borrado";						
	}

		@Override
		public ClientesDto convertClientesToDto(Clientes clientes) {
		ClientesDto clientesDto = new ClientesDto();		
		clientesDto.setIdCliente(clientes.getIdCliente());
		clientesDto.setNombre(clientes.getNombre());
		clientesDto.setApellido(clientes.getApellido());
		clientesDto.setEmail(clientes.getEmail());
		clientesDto.setDireccion(clientes.getDireccion());
		clientesDto.setMovil(clientes.getMovil());						
		return clientesDto;
	}

	@Override
	public List<ClientesDto> convertAllClientesToDto(List<Clientes> clientes) {
		List<ClientesDto> clientesDto = new ArrayList<ClientesDto>(); 
		for (Clientes cliente: clientes ){
			clientesDto.add( convertClientesToDto(cliente));
		}
		return clientesDto;
	}


}