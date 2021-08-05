package br.com.tormenta.app.interfaces.dto.register;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class PersonRequestDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String name;

    @NotBlank(message = "Campo e-mail é obrigatório")
    @Email(message = "Endereço de e-mail inválido")
    private String email;

    @NotBlank(message = "Campo senha é obrigatório")
    @Length(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    private String password;

}
