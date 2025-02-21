package com.corales.carritoCompras.exceptions;

public class CarritoCompraNoExisteException extends RuntimeException{
    public CarritoCompraNoExisteException(String message){
        super(message);
    }
}
