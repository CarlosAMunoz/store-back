package com.project.storeback.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.storeback.dto.DireccionesDto;
import com.project.storeback.models.Direcciones;

@Mapper(componentModel = "spring")
public interface DireccionesMapper {
    

    DireccionesMapper MAPPER = Mappers.getMapper(DireccionesMapper.class);

    
    DireccionesDto modelToDto(Direcciones direcciones);

    @InheritInverseConfiguration
    Direcciones dtoToModel(DireccionesDto direccionesDto);

    List<DireccionesDto> modelToDtos(List<Direcciones> direcciones);
}
