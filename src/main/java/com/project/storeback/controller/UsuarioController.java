package com.project.storeback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.storeback.dto.ResponseDto;
import com.project.storeback.dto.UsuarioDto;
import com.project.storeback.service.IUsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    
    private ResponseDto responseDto;


    public UsuarioController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired IUsuarioService usuarioService;


    @GetMapping(path = "todos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(usuarioService.listarUsuarios());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(usuarioService.buscarUsuario(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    

    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody UsuarioDto usuarioDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(usuarioService.guardarUsuario(usuarioDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        usuarioService.eliminarUsuario(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
