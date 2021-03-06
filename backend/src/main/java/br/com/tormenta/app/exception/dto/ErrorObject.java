package br.com.tormenta.app.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
}