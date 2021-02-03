package br.com.tormenta.app.exception.business.seguranca;

public class AuthenticateException extends RuntimeException {
    public AuthenticateException(String message) {
        super(message);
    }
}

