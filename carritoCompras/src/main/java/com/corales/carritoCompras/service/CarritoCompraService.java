package com.corales.carritoCompras.service;

import com.corales.carritoCompras.dto.CarritoCompraResponseDTO;
import com.corales.carritoCompras.dto.ProductoDTO;
import com.corales.carritoCompras.exceptions.CarritoCompraNoExisteException;
import com.corales.carritoCompras.exceptions.CarritoComprasVacioException;
import com.corales.carritoCompras.model.CarritoCompra;
import com.corales.carritoCompras.repository.ICarritoCompraRepository;
import com.corales.carritoCompras.repository.IProductoApiClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarritoCompraService implements ICarritoCompraService{

    private final ICarritoCompraRepository iCarritoCompraRepository;
    private final IProductoApiClient iProductoApiClient;

    @Override
    @CircuitBreaker(name = "producto", fallbackMethod = "fallbackGetProductos")
    @Retry(name = "producto")
    public CarritoCompraResponseDTO getCarritodCompra(Long numeroIdentificacion) {
        CarritoCompra carritoCompra = iCarritoCompraRepository.findById(numeroIdentificacion).orElseThrow(() -> new CarritoCompraNoExisteException("El carrito de compras que busca no existe en la base de datos"));
        if(carritoCompra.getProductos().isEmpty()) throw new CarritoComprasVacioException("El carrito de compras esta vacio");

        List<ProductoDTO> productoDTO = new ArrayList<>();

        for(Long codigoProducto : carritoCompra.getProductos()){
            ProductoDTO producto = obtenerProductoConRetry(codigoProducto);
            productoDTO.add(producto);
        }

        return new CarritoCompraResponseDTO(productoDTO, carritoCompra.getPrecioTotal());
    }

    @Retry(name = "producto")
    public ProductoDTO obtenerProductoConRetry(Long codigoProducto){
        return iProductoApiClient.getProducto(codigoProducto);
    }

    public CarritoCompraResponseDTO fallbackGetProductos(Throwable throwable){
        if(throwable instanceof CarritoCompraNoExisteException || throwable instanceof CarritoComprasVacioException)
            throw (RuntimeException) throwable;
        return new CarritoCompraResponseDTO(null, 0.0);
    }

    @Override
    @CircuitBreaker(name = "producto", fallbackMethod = "fallbackGetProductosNumeroIdentificacion")
    @Retry(name = "producto")
    public Long save(CarritoCompra carritoCompra) {
        double montoTotal = 0.0;

        for(Long numeroIdentificacion : carritoCompra.getProductos()){
            ProductoDTO producto = obtenerProductoConRetry(numeroIdentificacion);
            montoTotal += producto.getPrecio();
        }

        carritoCompra.setPrecioTotal(montoTotal);

        return iCarritoCompraRepository.save(carritoCompra).getNumeroIdentificacion();
    }

    public Long fallbackGetProductosNumeroIdentificacion(Throwable throwable){
        System.err.println("Error en save(): " + throwable.getMessage());
        return -1L;
    }


    @Override
    public void delete(Long codigoProducto) {

    }
}
