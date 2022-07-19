package com.project.storeback.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.storeback.dto.ProductosDto;
import com.project.storeback.models.Productos;

@Mapper(componentModel = "spring")
public interface ProductosMapper {
    
    ProductosMapper MAPPER = Mappers.getMapper(ProductosMapper.class);

    
    ProductosDto modelToDto(Productos productos);

    @InheritInverseConfiguration
    Productos dtoToModel(ProductosDto productosDto);

    List<ProductosDto> modelToDtos(List<Productos> productos);

}
