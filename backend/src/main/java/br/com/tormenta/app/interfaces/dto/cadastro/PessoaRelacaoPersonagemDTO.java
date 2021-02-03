package br.com.tormenta.app.interfaces.dto.cadastro;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class PessoaRelacaoPersonagemDTO {
    @NotNull
    private UUID id;
}
