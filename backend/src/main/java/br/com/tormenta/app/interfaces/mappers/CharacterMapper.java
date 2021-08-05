package br.com.tormenta.app.interfaces.mappers;

import br.com.tormenta.app.domain.model.Character;
import br.com.tormenta.app.interfaces.dto.register.CharacterDTO;

public class CharacterMapper {

    public static Character toCharacter(CharacterDTO dto) {
        return Character.builder()
                .id(dto.getId())
                .name(dto.getName())
                .breed(dto.getBreed())
                .origin(dto.getOrigin())
                .classe(dto.getClasse())
                .nivel(dto.getNivel())
                .divinity(dto.getDivinity())
                .lifeTotal(dto.getLifeTotal())
                .manaTotal(dto.getManaTotal())
                .person(PersonMapper.toPerson(dto.getPerson()))
                .currentLife(dto.getCurrentLife())
                .currentMana(dto.getCurrentMana())
                .displacement(dto.getDisplacement())
                .experiencePoints(dto.getExperiencePoints())
                .build();
    }

    public static CharacterDTO toCharacterDTO(Character character) {
        return CharacterDTO.builder()
                .id(character.getId())
                .name(character.getName())
                .breed(character.getBreed())
                .origin(character.getOrigin())
                .classe(character.getClasse())
                .nivel(character.getNivel())
                .divinity(character.getDivinity())
                .lifeTotal(character.getLifeTotal())
                .manaTotal(character.getManaTotal())
                .person(PersonMapper.toPersonRelationCharacterDTO(character.getPerson()))
                .currentLife(character.getCurrentLife())
                .currentMana(character.getCurrentMana())
                .displacement(character.getDisplacement())
                .experiencePoints(character.getExperiencePoints())
                .build();
    }

}
