package com.corales.venta.service;

import com.corales.venta.dto.CarritoCompraResponseDTO;
import com.corales.venta.dto.ProductoResponseDTO;
import com.corales.venta.dto.VentaResponseDTO;
import com.corales.venta.exception.VentaNoExisteException;
import com.corales.venta.model.Venta;
import com.corales.venta.repository.ICarritoCompraApiClient;
import com.corales.venta.repository.IVentaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaService implements IVentaService{

    private final IVentaRepository iVentaRepository;
    private final ICarritoCompraApiClient iCarritoCompraApiClient;

    @Override
    public void saveVenta(Venta venta) {
        iVentaRepository.save(venta);
    }

    @Override
    @CircuitBreaker(name = "carritoCompras", fallbackMethod = "fallbackGetCarrito")
    @Retry(name = "carritoCompras")
    public VentaResponseDTO getVenta(Long numeroIdentificacion) {
        Venta venta = iVentaRepository.findById(numeroIdentificacion)
                .orElseThrow(() -> new VentaNoExisteException("La venta que busca no se encuentra en la base de datos"));

        CarritoCompraResponseDTO carritoCompraResponseDTO = iCarritoCompraApiClient.getCarritoCompra(venta.getNumeroIdentificacionCarrito());

        VentaResponseDTO ventaResponseDTO = new VentaResponseDTO();
        ventaResponseDTO.setNumeroIdentificacionVenta(venta.getNumeroIdentificacion());
        ventaResponseDTO.setFecha(venta.getFecha());
        ventaResponseDTO.getListCarritoCompra().add(carritoCompraResponseDTO);

        return ventaResponseDTO;
    }

    public VentaResponseDTO fallbackGetCarrito(Throwable throwable){
        if(throwable instanceof VentaNoExisteException)
            throw (RuntimeException) throwable;
        return new VentaResponseDTO(null, null, null);
    }

}
