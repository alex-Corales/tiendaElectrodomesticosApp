package com.corales.carritoCompras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoCompraResponseDTO{
    private List<ProductoDTO> listaProductos;
    private double total;
}
