package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.ProductosDto;
import com.project.storeback.dto.mapper.ProductosMapper;
import com.project.storeback.models.Productos;
import com.project.storeback.repository.ProductosRepository;
import com.project.storeback.service.IProductosService;



@Service
public class ProductosServiceImp implements IProductosService{

    @Autowired ProductosRepository productosRepository;

    @Autowired ProductosMapper productosMapper;

    @Override
    public List<ProductosDto> listarProductos() {

        List<ProductosDto> productosDto = new ArrayList<>();
        List<Productos> productos = (List<Productos>) productosRepository.findAll();
        productosDto = productosMapper.modelToDtos(productos);
        return productosDto;
    }


    @Override
    public List<ProductosDto> listarProducosByCategoria(Long Id) {
        
        List<ProductosDto> productosDto = new ArrayList<>();
        List<Productos> productos = (List<Productos>) productosRepository.findByCategoria(Id);
        productosDto = productosMapper.modelToDtos(productos);
        return productosDto;
    }
    


    @Override
    public ProductosDto buscarProducto(Long Id) {
        ProductosDto productosDto = new ProductosDto();
        if(productosRepository.findById(Id).isPresent())
        {
            productosDto = productosMapper.modelToDto(productosRepository.findById(Id).get());
        }
        else
        {   
            return productosDto;
        }
        return productosDto;
    }

    @Override
    public ProductosDto guardarProducto(ProductosDto productosDto) {
        if (productosDto.getId() == null )
        {
            Productos productos = new Productos();
            productos = productosMapper.dtoToModel(productosDto);

            productos = productosRepository.save(productos);
            productosDto = productosMapper.modelToDto(productos);
        }
        else{
            Productos productos = productosRepository.findById(productosDto.getId()).get();

            productos = productosMapper.dtoToModel(productosDto);
            
            productos = productosRepository.save(productos);
            productosDto = productosMapper.modelToDto(productos);
        }
        return productosDto;
    }

    @Override
    public void eliminarProducto(Long Id) {
        productosRepository.deleteById(Id);
    }




}
