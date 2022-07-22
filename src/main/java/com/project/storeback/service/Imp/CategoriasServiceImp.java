package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.CategoriasDto;
import com.project.storeback.dto.mapper.CategoriasMapper;
import com.project.storeback.models.Categorias;
import com.project.storeback.repository.CategoriasRepository;
import com.project.storeback.service.ICategoriasService;

@Service
public class CategoriasServiceImp implements ICategoriasService{


    @Autowired CategoriasRepository categoriasRepository;
    @Autowired CategoriasMapper categoriasMapper;


    public List<CategoriasDto> listarCategorias() {
        List<CategoriasDto> categoriasDto = new ArrayList<>();
        List<Categorias> categorias = (List<Categorias>) categoriasRepository.findAll();
        categoriasDto = categoriasMapper.modelToDtos(categorias);
        return categoriasDto;
    }

    @Override
    public CategoriasDto buscarCategoria(Long Id) {
        CategoriasDto categoriasDto = new CategoriasDto();
        if(categoriasRepository.findById(Id).isPresent())
        {
            categoriasDto = categoriasMapper.modelToDto(categoriasRepository.findById(Id).get());
        }
        else
        {   
            return categoriasDto;
        }
        return categoriasDto;
    }

    @Override
    public CategoriasDto guardarCategoria(CategoriasDto categoriasDto) {
        if (categoriasDto.getId() == null)
        {
            Categorias categorias = new Categorias();
            categorias = categoriasMapper.dtoToModel(categoriasDto);

            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriasMapper.modelToDto(categorias);
        }
        else{
            Categorias categorias = categoriasRepository.findById(categoriasDto.getId()).get();

            categorias = categoriasMapper.dtoToModel(categoriasDto);
            
            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriasMapper.modelToDto(categorias);
        }
        return categoriasDto;
    }

    @Override
    public void eliminarCategoria(Long Id) {
        categoriasRepository.deleteById(Id);
        
    }
    
}
