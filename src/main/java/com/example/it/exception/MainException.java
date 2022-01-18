package com.example.it.exception;

public class MainException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final Integer codigo;

    public MainException(String msg) {
        super(msg);
        this.codigo = null;
    }

    public MainException(Throwable throwable) {
        super(throwable);
        this.codigo = null;
    }

    public MainException(String mensaje, Throwable throwable) {
        super(mensaje, throwable);
        this.codigo = null;
    }

    public MainException(Integer codigo, String msg) {
        super(msg);
        this.codigo = codigo;
    }

    public MainException(Integer codigo, String mensaje, Throwable e) {
        super(mensaje, e);
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
