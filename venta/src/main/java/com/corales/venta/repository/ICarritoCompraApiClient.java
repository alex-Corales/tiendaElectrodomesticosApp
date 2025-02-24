package com.corales.venta.repository;

import com.corales.venta.dto.CarritoCompraResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carritoCompras")
public interface ICarritoCompraApiClient {
    @GetMapping("/api/carrito/{numeroIdentificacion}")
    CarritoCompraResponseDTO getCarritoCompra(@PathVariable("numeroIdentificacion") Long numeroIdentificacion);
}
