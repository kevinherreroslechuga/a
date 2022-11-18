package org.generation.entity;


import javax.persistence.*;



import org.generation.entity.abstract_class.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.generation.entity.Clientes;




@Entity
@Table(name="Clientes")
public class Clientes extends ClientesAbstract {
		
	 	@JsonIgnore
		@Column(name="contrasena", updatable=false, length=CONTRASENA_MAX_LENGTH)	
		private String password;
	 	@Column(name="Socio_activo")
		protected Boolean socioActivo;
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		public Boolean getSocio_activo() {
			return socioActivo;
		}
		public void setSocio_activo(Boolean socio_activo) {
			this.socioActivo = socio_activo;
		}
		
	}

		

		

	
