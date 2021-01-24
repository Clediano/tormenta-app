package br.com.tormenta.app.exception.business;

public class AuthenticateException extends RuntimeException {
    public AuthenticateException(String message) {
        super(message);
    }
}

