package com.corales.venta.controller;

import com.corales.venta.dto.VentaResponseDTO;
import com.corales.venta.model.Venta;
import com.corales.venta.service.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ventas")
public class VentaController {

    private final IVentaService iVentaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveVenta(@RequestBody Venta venta){
        iVentaService.saveVenta(venta);
        return ResponseEntity.ok("El producto se creo correctamente");
    }

    @GetMapping("/{numeroIdentificacion}")
    public ResponseEntity<VentaResponseDTO> getVentabyNumeroIdentificacion(@PathVariable Long numeroIdentificacion){
        return ResponseEntity.ok(iVentaService.getVenta(numeroIdentificacion));
    }

}
