package com.example.it.service;

import com.example.it.dao.data.common.GeneralResponse;
import com.example.it.dao.data.form.FormRequest;
import com.example.it.dao.data.form.FormResponse;

public interface FormService {

    GeneralResponse saveForm(FormRequest request);

    FormResponse formResponse();

}
