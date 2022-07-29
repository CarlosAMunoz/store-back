package com.project.storeback.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "TBL_Usuario")
public class Usuario {
    
    @Id
    private Long Id_Usuario;
    private String Nombre;
    private String Email;
}
