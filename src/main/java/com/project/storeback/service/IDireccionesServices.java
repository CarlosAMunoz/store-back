package com.project.storeback.service;

import java.util.List;
import com.project.storeback.dto.DireccionesDto;

public interface IDireccionesServices {

    List<DireccionesDto> listarDirecciones();
    DireccionesDto buscarDireccion(Long Id);
    DireccionesDto guardarDireccion(DireccionesDto productosDto);
    void eliminarDireccion(Long Id);
}
