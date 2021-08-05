package br.com.tormenta.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "character")
public class Character implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cha_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cha_person_id", foreignKey = @ForeignKey(name = "fk_cha_per_id"))
    private Person person;

    @Column(name = "cha_name")
    private String name;

    @Column(name = "cha_breed")
    private String breed;

    @Column(name = "cha_origin")
    private String origin;

    @Column(name = "cha_classe")
    private String classe;

    @Column(name = "cha_nivel")
    private Integer nivel;

    @Column(name = "cha_divinity")
    private String divinity;

    @Column(name = "cha_life_total")
    private Integer lifeTotal;

    @Column(name = "cha_mana_total")
    private Integer manaTotal;

    @Column(name = "cha_current_life")
    private Integer currentLife;

    @Column(name = "cha_current_mana")
    private Integer currentMana;

    @Column(name = "cha_displacement")
    private Integer displacement;

    @Column(name = "cha_experience_points")
    private Integer experiencePoints;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;
}
