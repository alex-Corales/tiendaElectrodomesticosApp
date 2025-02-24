package com.corales.venta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompraResponseDTO {
    private List<ProductoResponseDTO> listaProductos = new ArrayList<>();
    private double total;
}
