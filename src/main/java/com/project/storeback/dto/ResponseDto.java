package com.project.storeback.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase Tipo Dto para  enmascarar las respuestas de los datos de los microservicios
 */
@Getter
@Setter
public class ResponseDto {
    private int codigoRespuesta; //200,201, 500, 404
    private String mensaje; //Proceso correctamente
    private Object data; // instancia, string, valor listado de algo
}
