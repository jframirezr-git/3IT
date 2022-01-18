package com.example.it.service.mapper.form;

import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class FormToFormDto extends CustomMapper<Form, SearchForm> {

    @Override
    public void mapAtoB(Form form, SearchForm searchForm, MappingContext context) {
        searchForm.setEmail(form.getEmail());
        searchForm.setId(form.getId());
        searchForm.setName(form.getName());
        searchForm.setTypeMusic(form.getMusicType());
    }
}
