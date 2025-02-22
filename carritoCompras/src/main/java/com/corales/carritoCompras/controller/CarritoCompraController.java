package com.corales.carritoCompras.controller;

import com.corales.carritoCompras.model.CarritoCompra;
import com.corales.carritoCompras.service.ICarritoCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoCompraController {

    private final ICarritoCompraService iCarritoCompraService;

    @GetMapping("/{numeroIdentificacion}")
    public ResponseEntity<?> getCarrito(@PathVariable Long numeroIdentificacion){
        return ResponseEntity.ok(iCarritoCompraService.getCarritodCompra(numeroIdentificacion));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam(required = false) Long numeroIdentificacion, @RequestParam Long codigoProducto){
        numeroIdentificacion = iCarritoCompraService.addProducto(numeroIdentificacion, codigoProducto);
        return ResponseEntity.ok("El producto se agrego correctamente en el carrito de compras con el identificacior: " + numeroIdentificacion);
    }

    @DeleteMapping("/delete/{codigoProducto}")
    public ResponseEntity<?> delete(@PathVariable Long codigoProducto){
        return ResponseEntity.ok(null);
    }

}
