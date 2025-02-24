package com.corales.venta.exception;

public class VentaNoExisteException extends RuntimeException{
    public VentaNoExisteException(String message){
        super(message);
    }
}
