package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.DireccionesDto;
import com.project.storeback.dto.mapper.DireccionesMapper;
import com.project.storeback.models.Direcciones;
import com.project.storeback.repository.DireccionesRepository;
import com.project.storeback.service.IDireccionesServices;


@Service
public class DireccionesServicesImp implements IDireccionesServices {


    @Autowired DireccionesRepository direccionesRepository;
    @Autowired DireccionesMapper direccionesMapper;

    @Override
    public List<DireccionesDto> listarDirecciones() {
        List<DireccionesDto> direccionesDto = new ArrayList<>();
        List<Direcciones> direcciones = (List<Direcciones>) direccionesRepository.findAll();
        direccionesDto = direccionesMapper.modelToDtos(direcciones);
        return direccionesDto;
    }

    @Override
    public DireccionesDto buscarDireccion(Long Id) {
        DireccionesDto direccionesDto = new DireccionesDto();
        if(direccionesRepository.findById(Id).isPresent())
        {
            direccionesDto = direccionesMapper.modelToDto(direccionesRepository.findById(Id).get());
        }
        else
        {   
            return direccionesDto;
        }
        return direccionesDto;
    }
    

    @Override
    public DireccionesDto guardarDireccion(DireccionesDto direccionesDto) {
        if (direccionesDto.getId_direccion() == null )
        {
            Direcciones direcciones = new Direcciones();
            direcciones = direccionesMapper.dtoToModel(direccionesDto);

            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);
        }
        else{
            Direcciones direcciones = direccionesRepository.findById(direccionesDto.getId_direccion()).get();

            direcciones = direccionesMapper.dtoToModel(direccionesDto);
            
            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);
        }
        return direccionesDto;
    }

    @Override
    public void eliminarDireccion(Long Id) {
        direccionesRepository.deleteById(Id);
    }
    
}
