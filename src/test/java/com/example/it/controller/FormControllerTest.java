package com.example.it.controller;

import com.example.it.dao.data.common.GeneralResponse;
import com.example.it.dao.data.form.FormRequest;
import com.example.it.dao.data.form.FormResponse;
import com.example.it.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormController.class)
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FormService formService;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void successResponseCreatedMethod() throws Exception {

        FormRequest request = FormRequest.builder()
                .name("Juan")
                .email("jframirezr22@gmail.com")
                .musicType("Pop")
                .build();

        when(formService.saveForm(request)).thenReturn(
            GeneralResponse.builder()
                .ok(true)
                .message("Se ha registrado tu respuesta correctamente")
                .build()
        );

        mockMvc.perform( MockMvcRequestBuilders
                .post("/create")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void successResponseSearchAllForms() throws Exception {

        when(formService.formResponse()).thenReturn(
                FormResponse.builder()
                .ok(true)
                .message("Petición realizada correctamente")
                .classicNumber(0)
                .jazzNumber(0)
                .popNumber(0)
                .rockNumber(0)
                .build()
        );


        mockMvc.perform( MockMvcRequestBuilders
                .get("/get")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void requiredEmail() throws Exception {

        FormRequest request = FormRequest.builder()
                .name("Juan")
                .email("jframirezr22.com")
                .musicType("Pop")
                .build();

        when(formService.saveForm(request)).thenReturn(
                GeneralResponse.builder()
                        .ok(false)
                        .message("El usuario con este email ya diligencio previamente el formulario")
                        .build()
        );

        mockMvc.perform( MockMvcRequestBuilders
                .post("/create")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
