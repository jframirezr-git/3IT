package com.example.it.dao.data.common;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean ok;

    private String message;
}
