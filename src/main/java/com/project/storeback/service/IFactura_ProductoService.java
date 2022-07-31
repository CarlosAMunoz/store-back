package com.project.storeback.service;

import java.util.List;

import com.project.storeback.dto.Factura_ProductoDto;

public interface IFactura_ProductoService {
    List<Factura_ProductoDto> listarFactura_Producto();
    Factura_ProductoDto buscarFactura_Producto(Long Id);
    Factura_ProductoDto guardarFactura_Producto(Factura_ProductoDto factura_ProductoDto);
    void eliminarFactura_Producto(Long Id);
}
