package com.everis.practicaspringcloudcompra.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicaspringcloudcompra.responses.CurrencyCompraResponse;

@FeignClient(name="PRACTICA-CLOUD-INVENTARIO-REST")
@RibbonClient(name="PRACTICA-CLOUD-INVENTARIO-REST")
public interface CurrencyInventarioServiceProxy {
	
	@GetMapping("/inventario/id/{idProducto}")
	public CurrencyCompraResponse consultaCompra(@PathVariable int idProducto);

}
