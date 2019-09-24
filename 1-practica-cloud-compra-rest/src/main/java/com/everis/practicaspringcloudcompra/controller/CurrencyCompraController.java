package com.everis.practicaspringcloudcompra.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicaspringcloudcompra.model.Configuracion;
import com.everis.practicaspringcloudcompra.responses.CurrencyCompraResponse;

@RestController
public class CurrencyCompraController {
	
	@Autowired
	private Configuracion configuracion;
	
	@GetMapping("/compra/idProducto/{idProducto}/cantidad/{cantidad}")
	public CurrencyCompraResponse obtenStock(@PathVariable int idProducto, @PathVariable int cantidad) {
		
		String url = "http://localhost:8000/inventario/id/{id}";
		
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", idProducto);
		
		CurrencyCompraResponse response = new CurrencyCompraResponse();
		try {
			ResponseEntity<CurrencyCompraResponse> respuesta = new RestTemplate().getForEntity(url, CurrencyCompraResponse.class, uriVariables);
			response = respuesta.getBody();
			if(cantidad<response.getInventario().getStock()) {
				if((response.getInventario().getStock()-cantidad)<(response.getInventario().getStock()*(configuracion.getReorden()/100))) {
					response.setSuccessful(false);
				}
				else {
					response.setSuccessful(true);
				}
			}
			else {
				response.setSuccessful(false);
			}
			
		}
		catch (Exception e){
			response.setSuccessful(false);
		}
		return response;
		
	}
}
