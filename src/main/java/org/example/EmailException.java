package org.example;

public class EmailException extends RuntimeException{

    private static final long serialVersionUID = 6546546L;

    public EmailException(final String mensaje){
        super(mensaje);
    }

}
