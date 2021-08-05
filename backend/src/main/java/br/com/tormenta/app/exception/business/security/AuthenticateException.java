package br.com.tormenta.app.exception.business.security;

public class AuthenticateException extends RuntimeException {
    public AuthenticateException(String message) {
        super(message);
    }
}

