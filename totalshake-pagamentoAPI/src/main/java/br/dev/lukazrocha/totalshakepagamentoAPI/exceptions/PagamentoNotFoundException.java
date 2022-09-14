package br.dev.lukazrocha.totalshakepagamentoAPI.exceptions;

public class PagamentoNotFoundException extends RuntimeException{

    public PagamentoNotFoundException(){
        super();
    }

    public PagamentoNotFoundException(String message){
        super(message);
    }

    public PagamentoNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
