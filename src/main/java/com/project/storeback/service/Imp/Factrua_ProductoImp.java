package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.Factura_ProductoDto;
import com.project.storeback.dto.mapper.Factura_ProductoMapper;
import com.project.storeback.models.Factura_Producto;
import com.project.storeback.repository.Factura_ProductoRepository;
import com.project.storeback.service.IFactura_ProductoService;


@Service
public class Factrua_ProductoImp implements IFactura_ProductoService{


    
    @Autowired Factura_ProductoRepository factura_ProductoRepository;
    @Autowired Factura_ProductoMapper factura_ProductoMapper;


    @Override
    public List<Factura_ProductoDto> listarFactura_Producto() {
        List<Factura_ProductoDto> factura_ProductoDtos = new ArrayList<>();
        List<Factura_Producto> factura_Productos = (List<Factura_Producto>) factura_ProductoRepository.findAll();
        factura_ProductoDtos = factura_ProductoMapper.modelToDtos(factura_Productos);
        return factura_ProductoDtos;
    }


    @Override
    public Factura_ProductoDto buscarFactura_Producto(Long Id) {
        Factura_ProductoDto factura_ProductoDto = new Factura_ProductoDto();
        if(factura_ProductoRepository.findById(Id).isPresent())
        {
            factura_ProductoDto = factura_ProductoMapper.modelToDto(factura_ProductoRepository.findById(Id).get());
        }
        else
        {   
            return factura_ProductoDto;
        }
        return factura_ProductoDto;
    }

    @Override
    public Factura_ProductoDto guardarFactura_Producto(Factura_ProductoDto factura_ProductoDto) {
        if (factura_ProductoDto.getId_Factura_Producto() == null)
        {
            Factura_Producto factura_Producto = new Factura_Producto();
            factura_Producto = factura_ProductoMapper.dtoToModel(factura_ProductoDto);

            factura_Producto = factura_ProductoRepository.save(factura_Producto);
            factura_ProductoDto = factura_ProductoMapper.modelToDto(factura_Producto);
        }
        else{
            Factura_Producto factura_Producto = factura_ProductoRepository.findById(factura_ProductoDto.getId_Factura_Producto()).get();

            factura_Producto = factura_ProductoMapper.dtoToModel(factura_ProductoDto);
            
            factura_Producto = factura_ProductoRepository.save(factura_Producto);
            factura_ProductoDto = factura_ProductoMapper.modelToDto(factura_Producto);
        }
        return factura_ProductoDto;
    }

    @Override
    public void eliminarFactura_Producto(Long Id) {
        factura_ProductoRepository.deleteById(Id);
    } 
}
