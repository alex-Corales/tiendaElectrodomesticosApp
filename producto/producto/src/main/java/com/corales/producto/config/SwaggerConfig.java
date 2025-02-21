package com.corales.producto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            title = "Servicio Producto",
            description = "Este servicio se encarga de manejar todos los productos",
            contact = @Contact (
                    name = "Alex Nahuel Corales",
                    url = "https://www.linkedin.com/in/alex-corales/",
                    email = "alexcorales21@gmail.com"
            )
    ),
    servers = {
            @Server(
                    description = "DEV SERVER",
                    url = "http://localhost:8081"
            )
    }
)
public class SwaggerConfig { }
