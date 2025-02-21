package com.corales.producto.service;

import com.corales.producto.dto.ProductoRequestDTO;
import com.corales.producto.exceptions.ProductoDuplicadoException;
import com.corales.producto.exceptions.ProductoNotFoundException;
import com.corales.producto.model.Producto;
import com.corales.producto.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService{

    private final IProductoRepository iProductoRepository;

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> listaProductos = iProductoRepository.findAll();
        if(listaProductos.isEmpty()) throw new ProductoNotFoundException("No se encontraron productos en la base de datos");
        return listaProductos;
    }

    @Override
    public Producto getProducto(Long codigoProducto) {
        return iProductoRepository.findById(codigoProducto).orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con el codigo: "+ codigoProducto));
    }

    @Override
    public void saveProducto(ProductoRequestDTO productoRequestDTO) {
        if (iProductoRepository.existsByNombreAndMarca(productoRequestDTO.nombre(), productoRequestDTO.marca()))
            throw new ProductoDuplicadoException("El producto ya se encuentra en la base de datos");

        Producto producto = new Producto();
        producto.setNombre(productoRequestDTO.nombre());
        producto.setMarca(productoRequestDTO.marca());
        producto.setPrecio(productoRequestDTO.precio());

        iProductoRepository.save(producto);
    }

    @Override
    public void updateProducto(Long codigoProducto, ProductoRequestDTO productoRequestDTO) {
        Producto producto = this.getProducto(codigoProducto);

        if(iProductoRepository.existsByNombreAndMarcaAndCodigoProductoNot(productoRequestDTO.nombre(), productoRequestDTO.marca(), codigoProducto))
            throw new ProductoDuplicadoException("El producto ya se encuentra en la base de datos");

        producto.setNombre(productoRequestDTO.nombre());
        producto.setMarca(productoRequestDTO.marca());
        producto.setPrecio(productoRequestDTO.precio());

        iProductoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long codigoProducto) {
        Producto producto = this.getProducto(codigoProducto);
        iProductoRepository.deleteById(codigoProducto);
    }
}
