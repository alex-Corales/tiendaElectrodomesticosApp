package com.corales.producto.controller;

import com.corales.producto.dto.ProductoRequestDTO;
import com.corales.producto.service.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService iProductoService;

    @GetMapping
    public ResponseEntity<?> getAllProductos(){
        return ResponseEntity.ok(iProductoService.getAllProductos());
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<?> getProducto(@PathVariable Long codigoProducto){
        return ResponseEntity.ok(iProductoService.getProducto(codigoProducto));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> saveProducto(@RequestBody @Valid ProductoRequestDTO productoRequestDTO){
        iProductoService.saveProducto(productoRequestDTO);
        return ResponseEntity.ok("El producto se creo correctamente");
    }

    @PutMapping("/editar/{codigoProducto}")
    public ResponseEntity<?> updateProducto(@PathVariable Long codigoProducto, @RequestBody @Valid ProductoRequestDTO productoRequestDTO){
        iProductoService.updateProducto(codigoProducto, productoRequestDTO);
        return ResponseEntity.ok("El producto se actualizo con exito");
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long codigoProducto){
        iProductoService.deleteProducto(codigoProducto);
        return ResponseEntity.ok("El producto se elimino correctamente");
    }
}
