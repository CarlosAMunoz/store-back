package com.project.storeback.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.storeback.dto.CarritoDto;
import com.project.storeback.models.Carrito;


@Mapper(componentModel = "spring")
public interface CarritoMapper {
        
    CarritoMapper MAPPER = Mappers.getMapper(CarritoMapper.class);

    CarritoDto modelToDto(Carrito carrito);

    @InheritInverseConfiguration
    Carrito dtoToModel(CarritoDto carritoDto);

    List<CarritoDto> modelToDtos(List<Carrito> carritos);
}
