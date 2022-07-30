package com.project.storeback.service;

import java.util.List;

import com.project.storeback.dto.CarritoDto;

public interface ICarritoService {
    List<CarritoDto> listarCarritos();
    CarritoDto buscarCarrito(Long Id);
    CarritoDto guardarCarrito(CarritoDto CarritoDto);
    void eliminarCarrito(Long Id);
}
