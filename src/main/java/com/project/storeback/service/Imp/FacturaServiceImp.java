package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.storeback.dto.FacturaDto;
import com.project.storeback.dto.mapper.FacturaMapper;
import com.project.storeback.models.Factura;
import com.project.storeback.repository.FacturaRepository;
import com.project.storeback.service.IFacturaService;

@Service
public class FacturaServiceImp implements IFacturaService{

    @Autowired FacturaRepository facturaRepository;
    @Autowired FacturaMapper facturaMapper;


    @Override
    public List<FacturaDto> listarFacturas() {
        List<FacturaDto> facturaDtos = new ArrayList<>();
        List<Factura> facturas = (List<Factura>) facturaRepository.findAll();
        facturaDtos = facturaMapper.modelToDtos(facturas);
        return facturaDtos;
    }

    @Override
    public FacturaDto buscarFactura(Long Id) {
        FacturaDto facturaDto = new FacturaDto();
        if(facturaRepository.findById(Id).isPresent())
        {
            facturaDto = facturaMapper.modelToDto(facturaRepository.findById(Id).get());
        }
        else
        {   
            return facturaDto;
        }
        return facturaDto;
    }

    @Override
    public FacturaDto guardarFactura(FacturaDto facturaDto) {
        if (facturaDto.getId_Factura() == null)
        {
            Factura factura = new Factura();
            factura = facturaMapper.dtoToModel(facturaDto);

            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);
        }
        else{
            Factura factura = facturaRepository.findById(facturaDto.getId_Factura()).get();

            factura = facturaMapper.dtoToModel(facturaDto);
            
            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);
        }
        return facturaDto;
    }

    @Override
    public void eliminarFactura(Long Id) {
        facturaRepository.deleteById(Id);
    }
}
