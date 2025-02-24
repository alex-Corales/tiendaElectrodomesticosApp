package com.corales.venta.service;

import com.corales.venta.dto.VentaResponseDTO;
import com.corales.venta.model.Venta;

public interface IVentaService {
    void saveVenta(Venta venta);
    VentaResponseDTO getVenta(Long numeroIdentificacion);
}
