package com.example.it.service.impl;

import com.example.it.dao.FormDao;
import com.example.it.dao.data.common.GeneralResponse;
import com.example.it.dao.data.form.FormRequest;
import com.example.it.dao.data.form.FormResponse;
import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;
import com.example.it.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final FormDao formDao;

    @Override
    public GeneralResponse saveForm(FormRequest request) {

        Form form;
        Optional<Form> formOptional;

        formOptional = formDao.searchForm(SearchForm.builder().email(request.getEmail()).build());

        if(formOptional.isPresent()){

            return GeneralResponse.builder()
                    .ok(false)
                    .message("El usuario con este email ya diligencio previamente el formulario")
                    .build();
        }

        form = Form.builder()
                .email(request.getEmail())
                .name(request.getName())
                .musicType(request.getMusicType())
                .build();

        formDao.saveForm(form);

        return GeneralResponse.builder()
                .ok(true)
                .message("Se ha registrado tu respuesta correctamente")
                .build();
    }

    @Override
    public FormResponse formResponse() {

        List<Form> formList = formDao.searchForm();
         int rockNumber = 0;
         int jazzNumber = 0;
         int classicNumber = 0;
         int popNumber = 0;

        if(formList == null){
            return FormResponse.builder()
                    .ok(false)
                    .message("No se han encontrado registros previos")
                    .build();
        }

        for(Form item: formList){
            if(item.getMusicType().equals("Pop")){
                popNumber += 1;
            }else if(item.getMusicType().equals("Classic")){
                classicNumber +=1;
            }
            else if(item.getMusicType().equals("Jazz")){
                jazzNumber +=1;
            }else if(item.getMusicType().equals("Rock")){
                rockNumber +=1;
            }
        }

        return FormResponse.builder()
                .ok(true)
                .message("Petición realizada correctamente")
                .classicNumber(classicNumber)
                .jazzNumber(jazzNumber)
                .popNumber(popNumber)
                .rockNumber(rockNumber)
                .build();
    }
}
