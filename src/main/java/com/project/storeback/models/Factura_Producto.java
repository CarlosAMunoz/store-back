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
@Table(name = "TBL_Factura_Producto")
public class Factura_Producto {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Factura_Producto;

    @ManyToOne
    @JoinColumn(name = "Id_Factura", referencedColumnName = "Id_Factura")
    private Factura Id_Factura;

    @ManyToOne
    @JoinColumn(name = "Id_Producto", referencedColumnName = "Id")
    private Productos Id_Producto;

    private String Nombre_Producto;
    private Double Cantidad;

}
