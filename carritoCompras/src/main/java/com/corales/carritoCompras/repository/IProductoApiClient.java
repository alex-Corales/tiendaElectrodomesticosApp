package com.corales.carritoCompras.repository;

import com.corales.carritoCompras.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto")
public interface IProductoApiClient {
    @GetMapping("/api/productos/{codigoProducto}")
    ProductoDTO getProducto(@PathVariable("codigoProducto") Long codigoProducto);
}
