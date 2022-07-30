package com.project.storeback.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarritoDto {

    private Long Id_Carrito;
    private Long Id_Producto;
    private Double Cantidad;
    private String Nombre_Producto;
    private Long Id_Persona;

}
