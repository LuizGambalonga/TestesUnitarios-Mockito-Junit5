package br.com.luiz_gambalonga.api.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String mensagem){
        super(mensagem);
    }
}
