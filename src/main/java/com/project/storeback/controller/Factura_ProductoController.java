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

import com.project.storeback.dto.Factura_ProductoDto;
import com.project.storeback.dto.ResponseDto;
import com.project.storeback.service.IFactura_ProductoService;

@RestController
@RequestMapping("api/factura_producto")
public class Factura_ProductoController {
    
    private ResponseDto responseDto;


    public Factura_ProductoController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired IFactura_ProductoService factura_ProductoService;
    

    @GetMapping(path = "todos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(factura_ProductoService.listarFactura_Producto());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(factura_ProductoService.buscarFactura_Producto(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody Factura_ProductoDto factura_ProductoDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(factura_ProductoService.guardarFactura_Producto(factura_ProductoDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        factura_ProductoService.eliminarFactura_Producto(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
