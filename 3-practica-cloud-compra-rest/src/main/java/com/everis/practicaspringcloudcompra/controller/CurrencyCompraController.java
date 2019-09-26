package com.everis.practicaspringcloudcompra.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicaspringcloudcompra.model.Compra;
import com.everis.practicaspringcloudcompra.model.Configuracion;
import com.everis.practicaspringcloudcompra.model.Inventario;
import com.everis.practicaspringcloudcompra.model.Mensaje;
import com.everis.practicaspringcloudcompra.proxy.CurrencyInventarioServiceProxy;
import com.everis.practicaspringcloudcompra.proxy.WhatsAppProxy;
import com.everis.practicaspringcloudcompra.responses.CurrencyCompraResponse;
import com.everis.practicaspringcloudcompra.service.CompraService;
import com.everis.practicaspringcloudcompra.service.InventarioService;

@RestController
public class CurrencyCompraController {
	@Autowired
	private WhatsAppProxy whatsAppProxy;
	
	@Autowired
	private CurrencyInventarioServiceProxy currencyInventarioServiceProxy;
	
	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private Configuracion configuracion;
	
	@GetMapping("/compra/idProducto/{idProducto}/cantidad/{cantidad}")
	public CurrencyCompraResponse obtenStock(@PathVariable int idProducto, @PathVariable int cantidad) {
		Compra compra = new Compra();
//		String url = "http://localhost:8000/inventario/id/{id}";
//		
//		Map<String, Integer> uriVariables = new HashMap<>();
//		uriVariables.put("id", idProducto);
		
		CurrencyCompraResponse response = new CurrencyCompraResponse();
		try {
//			ResponseEntity<CurrencyCompraResponse> respuesta = new RestTemplate().getForEntity(url, CurrencyCompraResponse.class, uriVariables);
//			response = respuesta.getBody();
			response = currencyInventarioServiceProxy.consultaCompra(idProducto);
			Inventario nuevoProducto = response.getInventario();

		//	System.out.println("PUERTO:" + response.getInventario().getPort());
			if(cantidad<response.getInventario().getStock()) {
				double minimo = response.getInventario().getStock()*configuracion.getReorden()/100;
				double remanente = response.getInventario().getStock()-cantidad; 
				if(remanente>minimo) {
					nuevoProducto.setStock((int)Math.round(remanente));
					inventarioService.CambioStock(nuevoProducto);
		//			DateFormat formato = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss");
					Date fecha = new Date();  
					response.setSuccessful(true);			
					response.setMessage("Compra verificada");
					compra.setCantidad(cantidad);
					compra.setFechahora(fecha);
					compra.setInventario(response.getInventario());
					compraService.insertar(compra);	
					compra.setIdcompra(compraService.obtenUltima().getIdcompra());
					response.setCompra(compra);		
					
				}
				else {
					response.setSuccessful(false);
					response.setMessage("No es posible comprar, la cantidad entra en conflicto con reorden");
				}
			}
			else {
				response.setSuccessful(false);
				response.setMessage("No es posible comprar, stock insuficiente");
				Mensaje mensaje = new Mensaje(response.getMessage());
				whatsAppProxy.enviaMensaje(mensaje);
			}
			
		}
		catch (Exception e){
			response.setSuccessful(false);
		}
		return response;
		
	}
	

	
	
	
}
