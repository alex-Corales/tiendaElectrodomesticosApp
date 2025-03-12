package com.corales.producto.exceptions;

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(String message){
        super(message);
    }
}
