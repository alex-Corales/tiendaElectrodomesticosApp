package com.corales.carritoCompras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private double precio;
}