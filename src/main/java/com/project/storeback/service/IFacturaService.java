package com.project.storeback.service;

import java.util.List;
import com.project.storeback.dto.FacturaDto;


public interface IFacturaService {
    List<FacturaDto> listarFacturas();
    FacturaDto buscarFactura(Long Id);
    FacturaDto guardarFactura(FacturaDto facturaDto);
    void eliminarFactura(Long Id);
}
