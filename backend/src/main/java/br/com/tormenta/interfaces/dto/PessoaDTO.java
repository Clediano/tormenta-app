package br.com.tormenta.interfaces.dto;

import br.com.tormenta.domain.model.Pessoa;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class PessoaDTO {

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{password.not.blank}")
    @Length(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String senha;

    public Pessoa transformaParaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setSenha(senha);

        return pessoa;
    }

}