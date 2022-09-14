package br.dev.lukazrocha.totalshakepagamentoAPI.exceptions;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {PagamentoNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage pedidoNotFoundException(PagamentoNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());

        return message;
    }
}