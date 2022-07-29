package com.project.storeback.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.storeback.dto.UsuarioDto;
import com.project.storeback.dto.mapper.UsuarioMapper;
import com.project.storeback.models.Usuario;
import com.project.storeback.repository.UsuarioRepository;
import com.project.storeback.service.IUsuarioService;


@Service
public class UsuarioServiceImp implements IUsuarioService{


    @Autowired UsuarioRepository usuarioRepository;

    @Autowired UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDto> listarUsuarios() {

        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        usuarioDtos = usuarioMapper.modelToDtos(usuarios);
        return usuarioDtos;
    }

    @Override
    public UsuarioDto buscarUsuario(Long Id) {
        UsuarioDto usuarioDto = new UsuarioDto();
        if(usuarioRepository.findById(Id).isPresent())
        {
            usuarioDto = usuarioMapper.modelToDto(usuarioRepository.findById(Id).get());
        }
        else
        {   
            return usuarioDto;
        }
        return usuarioDto;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto.getId_Usuario() == null )
        {
            Usuario usuario = new Usuario();
            usuario = usuarioMapper.dtoToModel(usuarioDto);

            usuario = usuarioRepository.save(usuario);
            usuarioDto = usuarioMapper.modelToDto(usuario);
        }
        else{
            Usuario usuario = usuarioRepository.findById(usuarioDto.getId_Usuario()).get();

            usuario = usuarioMapper.dtoToModel(usuarioDto);
            
            usuario = usuarioRepository.save(usuario);
            usuarioDto = usuarioMapper.modelToDto(usuario);
        }
        return usuarioDto;
    }

    @Override
    public void eliminarUsuario(Long Id) {
        usuarioRepository.deleteById(Id);
        
    }
    
}
