package com.project.storeback.dto;

import com.project.storeback.models.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionesDto {


    private Long Id_Direccion;
    private String Descripcion;
    private Usuario Id_Usuario;
}
