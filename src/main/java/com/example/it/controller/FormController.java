package com.example.it.controller;

import com.example.it.dao.data.common.Response;
import com.example.it.dao.data.form.FormRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;

public interface FormController {

    @ApiOperation(value = "Registrar formulario", notes = "Registrar formulario", nickname = "RegistrarFormulario",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "successful request", response = Response.class),
            @ApiResponse(code = 502, message = "integration error", response = Response.class),
            @ApiResponse(code = 206, message = "error request", response = Response.class)})
    @PostMapping(path = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response<Serializable>> saveForm(@Valid @RequestBody FormRequest request);

    @ApiOperation(value = "Buscar formulario", notes = "Buscar formulario", nickname = "BuscarFormulario",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "successful request", response = Response.class),
            @ApiResponse(code = 502, message = "integration error", response = Response.class),
            @ApiResponse(code = 206, message = "error request", response = Response.class)})
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity searchAllForm();
}
