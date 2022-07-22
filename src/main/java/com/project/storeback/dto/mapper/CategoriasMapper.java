package com.project.storeback.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.storeback.dto.CategoriasDto;
import com.project.storeback.models.Categorias;

@Mapper(componentModel = "spring")
public interface CategoriasMapper {
    
    CategoriasMapper MAPPER = Mappers.getMapper(CategoriasMapper.class);

    
    CategoriasDto modelToDto(Categorias categorias);

    @InheritInverseConfiguration
    Categorias dtoToModel(CategoriasDto categoriasDto);

    List<CategoriasDto> modelToDtos(List<Categorias> categorias);
}
