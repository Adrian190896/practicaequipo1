package com.everis.practicaspringcloudinventario.model;
// Generated 25/09/2019 01:22:22 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Inventario generated by hbm2java
 */
@Entity
@Table(name = "inventario", catalog = "mydb")
public class Inventario implements java.io.Serializable {

	private int id;
	private String nombre;
	private int stock;
	private int port;

	public Inventario() {
	}

	public Inventario(int id, String nombre, int stock, int port) {
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.port = port;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "stock", nullable = false)
	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name = "port", nullable = false)
	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
