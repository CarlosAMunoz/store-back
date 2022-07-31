package com.project.storeback.dto;

import com.project.storeback.models.Factura;
import com.project.storeback.models.Productos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Factura_ProductoDto {
    
    private Long Id_Factura_Producto;
    private Factura Id_Factura;
    private Productos Id_Producto;
    private String Nombre_Producto;
    private Double Cantidad;

}
