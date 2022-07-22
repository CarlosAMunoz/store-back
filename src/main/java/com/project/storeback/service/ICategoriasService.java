package com.project.storeback.service;

import java.util.List;
import com.project.storeback.dto.CategoriasDto;

public interface ICategoriasService {
    List<CategoriasDto> listarCategorias();
    CategoriasDto buscarCategoria(Long Id);
    CategoriasDto guardarCategoria(CategoriasDto categoriasDto);
    void eliminarCategoria(Long Id);
}
