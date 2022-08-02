package com.project.storeback.dto;

import com.project.storeback.models.Categorias;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductosDto {

    private Long Id;
    private String Nombre_Producto;
    private String Descripcion; 
    private Double Precio; 
    private Categorias id_Categoria; //Id
    private String Imagen; 
    private Double CantidadDisponible; 
}
    