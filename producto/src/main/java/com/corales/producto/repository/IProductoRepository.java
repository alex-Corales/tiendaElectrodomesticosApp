package com.corales.producto.repository;

import com.corales.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsByNombreAndMarca(String nombre, String marca);
    boolean existsByNombreAndMarcaAndCodigoProductoNot(String nombre, String marca, Long codigoProducto);
}
