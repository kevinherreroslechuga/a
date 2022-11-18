package org.generation.service;

import java.util.List;


import org.generation.entity.Clientes;
import org.generation.entity.dto.AuthClientes;
import org.generation.entity.dto.ClientesDto;




public interface IClientesService {
	
		public List<ClientesDto> findAllClientes() throws Exception;
		
		public Clientes findClientesById(Long id)throws Exception;
		
		public ClientesDto findClientesByEmail(AuthClientes authClientes);		
		
		public boolean existsClientesById(Long id);
		
		public boolean existsClientesByEmail(String email);
		
		public ClientesDto saveClientes(Clientes clientes) throws Exception;
		
		public ClientesDto updateClientes(Clientes clientes) throws Exception;
		
		public String deleteClientesById(Long id) throws Exception;
		
		public ClientesDto convertClientesToDto(Clientes clientes);
		
		public List<ClientesDto> convertAllClientesToDto(List<Clientes> clientes);
}
