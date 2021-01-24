package br.com.tormenta.infrastructure.exception.business;

public class AuthenticateException extends RuntimeException {
    public AuthenticateException(String message) {
        super(message);
    }
}

