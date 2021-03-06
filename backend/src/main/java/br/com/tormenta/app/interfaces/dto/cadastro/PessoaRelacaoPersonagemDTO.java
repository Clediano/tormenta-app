package br.com.tormenta.app.interfaces.dto.cadastro;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PessoaRelacaoPersonagemDTO {
    @NotNull
    private UUID id;

    private String nome;

    private String email;
}
