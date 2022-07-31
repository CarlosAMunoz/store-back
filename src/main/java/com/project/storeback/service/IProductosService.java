package com.project.storeback.service;

import java.util.List;
import com.project.storeback.dto.ProductosDto;

public interface IProductosService {
    List<ProductosDto> listarProductos();
    List<ProductosDto> listarProducosByCategoria(Long Id);
    ProductosDto buscarProducto(Long Id);
    ProductosDto guardarProducto(ProductosDto productosDto);
    void eliminarProducto(Long Id);

}
