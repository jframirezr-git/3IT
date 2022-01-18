package com.example.it.dao.data.form;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean ok;

    private String message;

    private Integer rockNumber;

    private Integer jazzNumber;

    private Integer classicNumber;

    private Integer popNumber;
}
