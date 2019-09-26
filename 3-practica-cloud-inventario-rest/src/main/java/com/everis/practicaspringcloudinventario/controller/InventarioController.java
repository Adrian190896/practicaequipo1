package com.everis.practicaspringcloudinventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicaspringcloudinventario.model.Inventario;
import com.everis.practicaspringcloudinventario.responses.InventarioResponses;
import com.everis.practicaspringcloudinventario.service.InventarioService;

@RestController
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;

	@Autowired
	private Environment environment;

	@GetMapping("/inventario/id/{id}")
	public InventarioResponses consultar(@PathVariable int id){
		InventarioResponses response = new InventarioResponses();
		try{
			Inventario producto = inventarioService.findById(id);
			if(producto == null) {
				response.setSuccessful(false);
				return response;
			}
			producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setInventario(producto);
			response.setSuccessful(true);
		}catch(Exception e)
		{
			response.setSuccessful(false);
		}
		return response;
		
	}

}
