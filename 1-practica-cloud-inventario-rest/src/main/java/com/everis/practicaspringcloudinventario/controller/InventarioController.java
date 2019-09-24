package com.everis.practicaspringcloudinventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicaspringcloudinventario.model.Inventario;
import com.everis.practicaspringcloudinventario.service.InventarioService;

@RestController
//@RequestMapping("inventario")
public class InventarioController {
	
	@Autowired
	private InventarioService inventarioService;
	
	@GetMapping("/inventario/id/{id}")
	public List<Inventario> consultar(@PathVariable long id){
		return inventarioService.listar();
	}

}
