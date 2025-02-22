package com.corales.carritoCompras.service;

import com.corales.carritoCompras.dto.CarritoCompraResponseDTO;
import com.corales.carritoCompras.model.CarritoCompra;

public interface ICarritoCompraService {
    CarritoCompraResponseDTO getCarritodCompra(Long numeroIdentificacion);
    Long addProducto(Long numeroIdentificacion, Long codigoProducto);
    void deleteProducto(Long numeroIndentificacion, Long codigoProducto);
}
