package br.com.luiz_gambalonga.api.services.exceptions;

public class DataIntegrateViolationException extends RuntimeException{

    public DataIntegrateViolationException(String mensagem){
        super(mensagem);
    }
}
