package br.com.tormenta.app.domain.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String senha;
}