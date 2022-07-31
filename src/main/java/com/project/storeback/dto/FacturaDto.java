package com.project.storeback.dto;
import java.sql.Date;
import com.project.storeback.models.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDto {

    private Long Id_Factura;
    private Double Total;
    private Usuario Id_Usuario;
    private String Nombre_Usuario;
    private Date Fecha_Compra;

}
