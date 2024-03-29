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

import com.project.storeback.dto.FacturaDto;
import com.project.storeback.dto.ResponseDto;
import com.project.storeback.service.IFacturaService;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {
    
        
    private ResponseDto responseDto;

    public FacturaController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired IFacturaService facturaService;


    @GetMapping(path = "todos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(facturaService.listarFacturas());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(facturaService.buscarFactura(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody FacturaDto facturaDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(facturaService.guardarFactura(facturaDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    
    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        facturaService.eliminarFactura(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

}
