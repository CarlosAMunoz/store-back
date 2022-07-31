package com.project.storeback.dto.mapper;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.storeback.dto.Factura_ProductoDto;
import com.project.storeback.models.Factura_Producto;

@Mapper(componentModel = "spring")
public interface Factura_ProductoMapper {

    Factura_ProductoMapper MAPPER = Mappers.getMapper(Factura_ProductoMapper.class);

    Factura_ProductoDto modelToDto(Factura_Producto factura_producto);

    @InheritInverseConfiguration
    Factura_Producto dtoToModel(Factura_ProductoDto factura_ProductoDto);

    List<Factura_ProductoDto> modelToDtos(List<Factura_Producto> factura_Productos);
}

