package br.com.tormenta.app.interfaces.dto.cadastro;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class PessoaResponseDTO {

    private UUID id;

    private String nome;

    private String email;


}
