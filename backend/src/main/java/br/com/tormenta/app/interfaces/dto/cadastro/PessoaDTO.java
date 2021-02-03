package br.com.tormenta.app.interfaces.dto.cadastro;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class PessoaDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "Campo e-mail é obrigatório")
    @Email(message = "Endereço de e-mail inválido")
    private String email;

    @NotBlank(message = "Campo senha é obrigatório")
    @Length(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String senha;

}
