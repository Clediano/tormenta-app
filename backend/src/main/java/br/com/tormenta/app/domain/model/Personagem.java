package br.com.tormenta.app.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "personagem")
public class Personagem implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "per_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "per_pessoa_id", foreignKey = @ForeignKey(name = "fk_per_pes_id"))
    private Pessoa pessoa;

    @Column(name = "per_nome")
    private String nome;

    @Column(name = "per_raca")
    private String raca;

    @Column(name = "per_origem")
    private String origem;

    @Column(name = "per_classe")
    private String classe;

    @Column(name = "per_nivel")
    private Integer nivel;

    @Column(name = "per_divindade")
    private String divindade;

    @Column(name = "per_vida_total")
    private Integer vidaTotal;

    @Column(name = "per_mana_total")
    private Integer manaTotal;

    @Column(name = "per_vida_atual")
    private Integer vidaAtual;

    @Column(name = "per_mana_atual")
    private Integer manaAtual;

    @Column(name = "per_deslocamento")
    private Integer deslocamento;

    @Column(name = "per_pontos_exp")
    private Integer pontosExperiencia;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private Date criado_em;

    @UpdateTimestamp
    @Column(name = "alterado_em")
    private Date alterado_em;
}
