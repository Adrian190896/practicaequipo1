package com.everis.practicaspringcloudcompra.model;
// Generated 25/09/2019 03:21:43 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.everis.practicaspringcloudcompra.model.Inventario;
/**
 * Compra generated by hbm2java
 */
@Entity
@Table(name = "compra", catalog = "mydb")
public class Compra implements java.io.Serializable {

	private int idcompra;
	private Inventario inventario;
	private Date fechahora;
	private int cantidad;

	public Compra() {
	}

	public Compra(int idcompra, Inventario inventario, Date fechahora, int cantidad) {
		this.idcompra = idcompra;
		this.inventario = inventario;
		this.fechahora = fechahora;
		this.cantidad = cantidad;
	}

	@Id

	@Column(name = "idcompra", unique = true, nullable = false)
	public int getIdcompra() {
		return this.idcompra;
	}

	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto", nullable = false)
	public Inventario getInventario() {
		return this.inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechahora", nullable = false, length = 19)
	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
