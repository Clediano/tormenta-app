package br.com.tormenta.app.interfaces.dto;

import br.com.tormenta.app.domain.model.Personagem;
import br.com.tormenta.app.domain.model.Pessoa;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class PersonagemDTO {

    @NotBlank(message = "{name.not.blank}")
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

    public Personagem transformaParaPersonagem() {
        Personagem personagem = new Personagem();
        personagem.setNome(nome);
        personagem.setRaca(raca);
        personagem.setOrigem(origem);
        personagem.setClasse(classe);
        personagem.setNivel(nivel);
        personagem.setDivindade(divindade);
        personagem.setVidaTotal(vidaTotal);
        personagem.setVidaAtual(vidaAtual);
        personagem.setManaTotal(manaTotal);
        personagem.setManaAtual(manaAtual);
        personagem.setDeslocamento(deslocamento);
        personagem.setPontosExperiencia(pontosExperiencia);
        personagem.setPessoa(this.convertPessoaRelacaoPersonagemDTOParaPessoa());
        return personagem;
    }

    private Pessoa convertPessoaRelacaoPersonagemDTOParaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.pessoa.getId());

        return pessoa;
    }

}
