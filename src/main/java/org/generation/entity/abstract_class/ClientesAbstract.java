package org.generation.entity.abstract_class;


import javax.persistence.*;





@MappedSuperclass
public abstract class ClientesAbstract {
	public static final int NOMBRE_MAX_LENGTH = 150;
	public static final int APELLIDO_MAX_LENGTH = 150;
	public static final int MOVIL_MAX_LENGTH = 150;
	public static final int EMAIL_MAX_LENGTH = 150;
	public static final int CONTRASENA_MAX_LENGTH = 150;
	public static final int DIRECCION_MAX_LENGTH = 200;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_cliente")
	protected Long idCliente;
	@Column(name="nombre", length=NOMBRE_MAX_LENGTH)
	protected String nombre;
	@Column(name="apellido",  length=APELLIDO_MAX_LENGTH  )
	protected String apellido;
	@Column(name="movil", length=MOVIL_MAX_LENGTH )
	protected Long movil;

	@Column(name="email", updatable=false, length=EMAIL_MAX_LENGTH)	
	protected String email;
	@Column(name="direccion", length=DIRECCION_MAX_LENGTH)
	protected String direccion;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getMovil() {
		return movil;
	}
	public void setMovil(Long movil) {
		this.movil = movil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	


}
