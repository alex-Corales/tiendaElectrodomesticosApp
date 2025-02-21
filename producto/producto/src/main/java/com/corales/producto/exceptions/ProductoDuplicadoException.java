package com.corales.producto.exceptions;

public class ProductoDuplicadoException extends RuntimeException{
    public ProductoDuplicadoException(String message){
        super(message);
    }
}
