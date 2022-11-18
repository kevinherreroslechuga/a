package org.generation.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_Venta")
	private Long idVenta;
	@Column(name = "created_at", insertable=false,  updatable=false , columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clientes idCliente;

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}


	
}
