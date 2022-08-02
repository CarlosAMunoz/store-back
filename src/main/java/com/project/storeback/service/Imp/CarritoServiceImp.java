package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.CarritoDto;
import com.project.storeback.dto.mapper.CarritoMapper;
import com.project.storeback.models.Carrito;
import com.project.storeback.repository.CarritoRepository;
import com.project.storeback.service.ICarritoService;


@Service
public class CarritoServiceImp implements ICarritoService{

    
    @Autowired CarritoRepository carritoRepository;
    @Autowired CarritoMapper carritoMapper;

    @Override
    public List<CarritoDto> listarCarritos() {
        List<CarritoDto> carritoDtos = new ArrayList<>();
        List<Carrito> carritos = (List<Carrito>) carritoRepository.findAll();
        carritoDtos = carritoMapper.modelToDtos(carritos);
        return carritoDtos;
    }

    @Override
    public CarritoDto buscarCarrito(Long Id) {
        CarritoDto carritoDto = new CarritoDto();
        if(carritoRepository.findById(Id).isPresent())
        {
            carritoDto = carritoMapper.modelToDto(carritoRepository.findById(Id).get());
        }
        else
        {   
            return carritoDto;
        }
        return carritoDto;
    }

    @Override
    public CarritoDto guardarCarrito(CarritoDto carritoDto) {
        if (carritoDto.getId_Carrito() == null)
        {
            Carrito carrito = new Carrito();
            carrito = carritoMapper.dtoToModel(carritoDto);

            carrito = carritoRepository.save(carrito);
            carritoDto = carritoMapper.modelToDto(carrito);
        }
        else{
            Carrito carrito = carritoRepository.findById(carritoDto.getId_Carrito()).get();

            carrito = carritoMapper.dtoToModel(carritoDto);
            
            carrito = carritoRepository.save(carrito);
            carritoDto = carritoMapper.modelToDto(carrito);
        }
        return carritoDto;
    }

    @Override
    public void eliminarCarrito(Long Id) {
        carritoRepository.deleteById(Id);
        
    }

    @Override
    public void eliminarTodoCarrito() {
        carritoRepository.deleteAll();
        
    }
    
}
