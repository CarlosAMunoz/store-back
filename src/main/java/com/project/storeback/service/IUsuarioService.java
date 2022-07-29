package com.project.storeback.service;

import java.util.List;

import com.project.storeback.dto.UsuarioDto;

public interface IUsuarioService {

    List<UsuarioDto> listarUsuarios();
    UsuarioDto buscarUsuario(Long Id);
    UsuarioDto guardarUsuario(UsuarioDto UsuarioDto);
    void eliminarUsuario(Long Id);

}
