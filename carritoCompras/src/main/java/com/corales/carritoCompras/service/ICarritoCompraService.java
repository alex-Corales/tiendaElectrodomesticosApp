package com.corales.carritoCompras.service;

import com.corales.carritoCompras.dto.CarritoCompraResponseDTO;
import com.corales.carritoCompras.model.CarritoCompra;

public interface ICarritoCompraService {
    CarritoCompraResponseDTO getCarritodCompra(Long numeroIdentificacion);
    Long save(CarritoCompra carritoCompra);
    void delete(Long codigoProducto);
}
