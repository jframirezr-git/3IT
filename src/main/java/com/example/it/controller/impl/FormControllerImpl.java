package com.example.it.controller.impl;

import com.example.it.controller.FormController;
import com.example.it.dao.data.common.ErrorResponse;
import com.example.it.dao.data.common.Response;
import com.example.it.dao.data.form.FormRequest;
import com.example.it.service.FormService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;

@Api(value = "Form", tags = "Form")
@RestController
@RequiredArgsConstructor
public class FormControllerImpl implements FormController {

    private final FormService formService;

    @Override
    public ResponseEntity<Response<Serializable>> saveForm(@Valid FormRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Response<>(formService.saveForm(request), new ErrorResponse()));
    }

    @Override
    public ResponseEntity searchAllForm() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(formService.formResponse(), new ErrorResponse()));
    }
}
