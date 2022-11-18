package org.generation.entity;


import javax.persistence.*;

@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_Producto")
	private Long idProducto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="precio")
	private Long Precio;
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getPrecio() {
		return Precio;
	}
	public void setPrecio(Long precio) {
		Precio = precio;
	}
}
