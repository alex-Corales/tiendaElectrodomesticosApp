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
    public ResponseEntity<?> save(@RequestBody CarritoCompra carritoCompra){
        return ResponseEntity.ok("El numero de identificacion de su carrito es: "+ iCarritoCompraService.save(carritoCompra));
    }

    @DeleteMapping("/delete/{codigoProducto}")
    public ResponseEntity<?> delete(@PathVariable Long codigoProducto){
        return ResponseEntity.ok(null);
    }

}
