package br.com.tormenta.app.domain.model;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final UUID id;
    private final String nome;
    private final String email;
    private final String token;
}