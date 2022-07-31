package com.project.storeback.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.project.storeback.dto.FacturaDto;
import com.project.storeback.models.Factura;


@Mapper(componentModel = "spring")
public interface FacturaMapper {
    
    FacturaMapper MAPPER = Mappers.getMapper(FacturaMapper.class);

    FacturaDto modelToDto(Factura factura);

    @InheritInverseConfiguration
    Factura dtoToModel(FacturaDto facturaDto);

    List<FacturaDto> modelToDtos(List<Factura> factura);
}
