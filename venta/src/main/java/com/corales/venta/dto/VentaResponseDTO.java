package com.corales.venta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaResponseDTO {
    public Long numeroIdentificacionVenta;
    public LocalDate fecha;
    public List<CarritoCompraResponseDTO> listCarritoCompra = new ArrayList<>();
}
