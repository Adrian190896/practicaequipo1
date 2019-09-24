package com.everis.practicaspringcloudcompra.responses;

import com.everis.practicaspringcloudcompra.model.Inventario;

public class CurrencyCompraResponse {
	private boolean succesful;
	private Inventario producto;
	public boolean isSuccesful() {
		return succesful;
	}
	public void setSuccesful(boolean succesful) {
		this.succesful = succesful;
	}
	public Inventario getProducto() {
		return producto;
	}
	public void setProducto(Inventario producto) {
		this.producto = producto;
	}
	
	
}
