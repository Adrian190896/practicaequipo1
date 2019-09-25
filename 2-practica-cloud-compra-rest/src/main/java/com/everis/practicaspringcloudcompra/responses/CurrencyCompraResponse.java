package com.everis.practicaspringcloudcompra.responses;

import com.everis.practicaspringcloudcompra.model.Inventario;

public class CurrencyCompraResponse {
	private boolean successful;
	private Inventario inventario;
	private String message;
	
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
	
	
	
}
