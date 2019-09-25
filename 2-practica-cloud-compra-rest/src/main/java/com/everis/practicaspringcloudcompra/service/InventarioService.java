package com.everis.practicaspringcloudcompra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicaspringcloudcompra.model.Inventario;
import com.everis.practicaspringcloudcompra.repository.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventarioRepository;
	
	public void CambioStock(Inventario inventario) {
		inventarioRepository.save(inventario);
	}
}
