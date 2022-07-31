package com.project.storeback.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "TBL_Factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Factura;
    private Double Total;

    @ManyToOne
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    private Usuario Id_Usuario;
    private String Nombre_Usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Compra;

}
