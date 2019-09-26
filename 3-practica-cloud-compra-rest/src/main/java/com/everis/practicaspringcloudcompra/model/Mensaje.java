package com.everis.practicaspringcloudcompra.model;

public class Mensaje {
	private String numero = "525513094912";
	private String mensaje;
	
	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getNumero() {
		return numero;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
