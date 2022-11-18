package org.generation.repository;

import java.util.Optional;




import org.springframework.data.repository.CrudRepository;

import org.generation.entity.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long>{
	Optional<Clientes> findByEmail(String email);//lanza un aexcepcion
	Iterable<Clientes> findBySocioActivo(Boolean state);//presenta los que esten activos
	Iterable<Clientes> findBySocioActivoOrderByApellidoAsc(Boolean state);//para ordenarlo por apellido
	boolean existsByEmail(String email);
	

}