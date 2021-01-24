package br.com.tormenta.security.interfaces.dto;

import br.com.tormenta.app.domain.model.Pessoa;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class LoginDTO {

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{password.not.blank}")
    @Length(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String senha;

    public Pessoa transformaParaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(email);
        pessoa.setSenha(senha);
        return pessoa;
    }

}