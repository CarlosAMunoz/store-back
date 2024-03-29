package com.project.storeback.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "TBL_Producto")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre_Producto;
    private String Descripcion; 
    private Double Precio; 

    @ManyToOne   
    @JoinColumn(name = "Id_Categoria", referencedColumnName = "Id_Categoria")
    private Categorias Id_Categoria;
    
    private String Imagen; 
    private Double CantidadDisponible; 

}
 