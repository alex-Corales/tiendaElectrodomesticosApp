package com.corales.carritoCompras.repository;

import com.corales.carritoCompras.model.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {
}
