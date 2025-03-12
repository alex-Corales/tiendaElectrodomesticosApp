package com.corales.producto.service;

import com.corales.producto.dto.ProductoRequestDTO;
import com.corales.producto.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getAllProductos();
    Producto getProducto(Long codigoProducto);
    void saveProducto(ProductoRequestDTO productoRequestDTO);
    void updateProducto(Long codigoProducto, ProductoRequestDTO productoRequestDTO);
    void deleteProducto(Long codigoProducto);
}
