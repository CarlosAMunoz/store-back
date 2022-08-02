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

import com.project.storeback.dto.CarritoDto;
import com.project.storeback.dto.ResponseDto;
import com.project.storeback.service.ICarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {
    
    private ResponseDto responseDto;


    public CarritoController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired ICarritoService carritoService;


    @GetMapping(path = "todos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(carritoService.listarCarritos());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody CarritoDto carritoDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(carritoService.guardarCarrito(carritoDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        carritoService.eliminarCarrito(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping(path = "eliminartodo")
    public ResponseEntity<ResponseDto> eliminar()
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        carritoService.eliminarTodoCarrito();
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

