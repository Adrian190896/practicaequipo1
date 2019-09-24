package com.everis.practicaspringcloudcompra.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
	
@Component
@ConfigurationProperties("config")
public class Configuracion {
	private long reorden;

	public long getReorden() {
		return reorden;
	}

	public void setReorden(long reorden) {
		this.reorden = reorden;
	}



	
	
	
}
