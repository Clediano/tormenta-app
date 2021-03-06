package br.com.tormenta.app.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pes_id")
    private UUID id;

    @Column(name = "pes_nome")
    private String nome;

    @Column(name = "pes_email")
    private String email;

    @Column(name = "pes_senha")
    private String senha;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private Date criado_em;

    @UpdateTimestamp
    @Column(name = "alterado_em")
    private Date alterado_em;
}
