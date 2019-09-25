package com.everis.practicaspringcloudcompra.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicaspringcloudcompra.responses.CurrencyCompraResponse;

@FeignClient(name="inventario-service")
@RibbonClient(name="inventario-service")
public interface CurrencyInventarioServiceProxy {
	
	@GetMapping("/compra/idProducto/{idProducto}/cantidad/{cantidad}")
	public CurrencyCompraResponse consultaCompra(@PathVariable int idProducto, @PathVariable int cantidad);

}
