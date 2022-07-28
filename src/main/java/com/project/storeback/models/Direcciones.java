package com.project.storeback.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "TBL_Direccion")
public class Direcciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_direccion;
    private String descripcion;

}   
