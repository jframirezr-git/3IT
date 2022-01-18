package com.example.it.dao;

import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;

import java.util.List;
import java.util.Optional;

public interface FormDao {

    /**
     * Save form
     *
     * @param form
     */
    void saveForm(Form form);

    /**
     * Search form
     *
     * @param searchForm
     */
    Optional<Form> searchForm(SearchForm searchForm);


    /**
     * Search all forms
     * @return
     */
    List<Form> searchForm();


}
