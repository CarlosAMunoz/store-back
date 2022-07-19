package com.project.storeback.excepciones;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException()
    {
        super("No existen registros");
    }
}
