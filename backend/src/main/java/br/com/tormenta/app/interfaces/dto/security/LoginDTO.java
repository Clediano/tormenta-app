package br.com.tormenta.app.interfaces.dto.security;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class LoginDTO {

    @NotBlank(message = "E-mail é um campo obrigatório")
    @Email(message = "E-mail inválido, verifique")
    private String email;

    @NotBlank(message = "A senha é um campo obrigatório")
    @Length(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String password;
}
