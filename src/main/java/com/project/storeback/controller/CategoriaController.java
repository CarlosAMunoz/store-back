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

import com.project.storeback.dto.CategoriasDto;
import com.project.storeback.dto.ResponseDto;
import com.project.storeback.service.ICategoriasService;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    
    private ResponseDto responseDto;


    public CategoriaController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired ICategoriasService categoriasService;


    @GetMapping(path = "todos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriasService.listarCategorias());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriasService.buscarCategoria(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody CategoriasDto categoriasDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(categoriasService.guardarCategoria(categoriasDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        categoriasService.eliminarCategoria(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

