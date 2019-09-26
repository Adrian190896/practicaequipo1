package com.everis.practicaspringcloudcompra.responses;

import java.util.Date;

import com.everis.practicaspringcloudcompra.model.Compra;
import com.everis.practicaspringcloudcompra.model.Inventario;

public class CurrencyCompraResponse {
	private boolean successful;
	private Inventario inventario;
	private String message;
	private Compra compra;
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
	
	
}
