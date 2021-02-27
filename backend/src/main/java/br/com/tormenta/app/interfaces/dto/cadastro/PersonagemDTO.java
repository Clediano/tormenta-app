package br.com.tormenta.app.interfaces.dto.cadastro;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PersonagemDTO {

    private UUID id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "Campo raça é obrigatório")
    private String raca;

    private String origem;

    @NotBlank(message = "Campo classe é obrigatório")
    private String classe;

    @NotNull(message = "Campo nivel é obrigatório")
    private Integer nivel;

    private String divindade;

    @NotNull(message = "Campo vida total é obrigatório")
    private Integer vidaTotal;

    @NotNull(message = "Campo mana total é obrigatório")
    private Integer manaTotal;

    @Valid
    private PessoaRelacaoPersonagemDTO pessoa;

    private Integer vidaAtual;

    private Integer manaAtual;

    private Integer deslocamento;

    private Integer pontosExperiencia;


}
