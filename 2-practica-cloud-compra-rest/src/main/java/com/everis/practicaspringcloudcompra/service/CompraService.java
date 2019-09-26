package com.everis.practicaspringcloudcompra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.everis.practicaspringcloudcompra.model.Compra;
import com.everis.practicaspringcloudcompra.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	public Compra obtenUltima(){
		List<Compra> listaCompras=compraRepository.findAll();
		Compra ultimaCompra = listaCompras.get(listaCompras.size()-1);
		return ultimaCompra;
	}
	
	public Compra insertar(Compra compra) {
		return compraRepository.save(compra);
	}
	
}
