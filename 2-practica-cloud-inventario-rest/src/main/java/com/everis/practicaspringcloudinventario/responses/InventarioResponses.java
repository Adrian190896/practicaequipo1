package com.everis.practicaspringcloudinventario.responses;

import com.everis.practicaspringcloudinventario.model.Inventario;

public class InventarioResponses {
	
	private boolean successful;
	private Inventario inventario;
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
	

}
