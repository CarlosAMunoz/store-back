package com.project.storeback.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductosDto {

    private Long Id;
    private String Nombre;
    private String Descripcion; 
    private Double Precio; 
    private List<String> Categorias; //Para listar
    private List<Long> AsignarCategorias; //[1,2,4,6] los vamos para guardar
    private String Imagen; 
}
    