package com.everis.practicaspringcloudinventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicaspringcloudinventario.model.Inventario;
import com.everis.practicaspringcloudinventario.repository.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventarioRepository;
	
	public Inventario findById(int id){
		return inventarioRepository.findById(id);
	}
}
