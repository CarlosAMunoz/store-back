package com.project.storeback.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_Carrito")
public class Carrito {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Carrito;
    private Long Id_Producto;
    private Double Cantidad;
    private String Nombre_Producto;
    private Long Id_Persona;

}
