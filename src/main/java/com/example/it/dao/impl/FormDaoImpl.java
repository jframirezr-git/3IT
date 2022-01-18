package com.example.it.dao.impl;

import com.example.it.dao.FormDao;
import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;
import com.example.it.dao.repositories.FormRepository;
import com.example.it.dao.specification.FormSpecification;
import com.example.it.exception.DataSourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormDaoImpl implements FormDao {

    private final FormRepository repository;

    @Override
    public void saveForm(Form form) {
       try {
           repository.save(form);
       } catch (DataSourceException e){
           log.error("Data base error");
           throw new DataSourceException(1000, "Data base error");
       }
    }

    @Override
    public Optional<Form> searchForm(SearchForm searchForm) {

        List<Form> forms;

        try {
            FormSpecification formSpecification = new FormSpecification(searchForm);
            forms = repository.findAll(formSpecification);
        }catch (DataSourceException e){
            log.error("Data base error");
            throw new DataSourceException(1000, "Data base error");
        }

        return isEmpty(forms) ? Optional.empty() : forms.stream().findFirst();
    }

    @Override
    public List<Form> searchForm() {

        List<Form> forms;

        try {
            forms = repository.findAll();
        }catch (DataSourceException e){
            log.error("Data base error");
            throw new DataSourceException(1000, "Data base error");
        }

        return isEmpty(forms) ? null : forms;
    }

}
