package com.example.it.exception;

import javax.validation.constraints.NotBlank;

public class DataSourceException extends MainException {
    private static final long serialVersionUID = 1L;
    private final Integer codigo;

    public DataSourceException(@NotBlank Integer codigo, String msg) {
        this(codigo, msg, null);
    }


    public DataSourceException(@NotBlank Integer codigo, String msg, Throwable causa) {
        super(msg, causa);
        this.codigo = codigo;
    }

    /**
     * @return the codigo
     */
    @Override
    public Integer getCodigo() {
        return codigo;
    }
}
