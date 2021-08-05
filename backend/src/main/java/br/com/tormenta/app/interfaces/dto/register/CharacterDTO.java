package br.com.tormenta.app.interfaces.dto.register;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class CharacterDTO {

    private UUID id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String name;

    @NotBlank(message = "Campo raça é obrigatório")
    private String breed;

    private String origin;

    @NotBlank(message = "Campo classe é obrigatório")
    private String classe;

    @NotNull(message = "Campo nivel é obrigatório")
    private Integer nivel;

    private String divinity;

    @NotNull(message = "Campo vida total é obrigatório")
    private Integer lifeTotal;

    @NotNull(message = "Campo mana total é obrigatório")
    private Integer manaTotal;

    @Valid
    private PersonRelationCharacterDTO person;

    private Integer currentLife;

    private Integer currentMana;

    private Integer displacement;

    private Integer experiencePoints;
}
