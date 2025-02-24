package com.corales.venta.repository;

import com.corales.venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository  extends JpaRepository<Venta, Long> {
}
