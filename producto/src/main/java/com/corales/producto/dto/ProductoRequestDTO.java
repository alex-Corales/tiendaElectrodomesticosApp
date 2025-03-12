package com.corales.producto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductoRequestDTO(@NotBlank (message = "El nombre no puede estar vacio") String nombre,
                                 @NotBlank (message = "La marca no puede estar vacia") String marca,
                                 @Positive (message = "Ingrese un valor mayor a 0") double precio) { }
