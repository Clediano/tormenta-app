package br.com.tormenta.app.interfaces.mappers;

import br.com.tormenta.app.domain.model.Person;
import br.com.tormenta.app.interfaces.dto.register.PersonRelationCharacterDTO;
import br.com.tormenta.app.interfaces.dto.register.PersonRequestDTO;
import br.com.tormenta.app.interfaces.dto.register.PersonResponseDTO;

public class PersonMapper {

    public static Person toPerson(PersonRequestDTO dto) {
        return Person.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public static Person toPerson(PersonRelationCharacterDTO dto) {
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static PersonResponseDTO toPersonResponseDTO(Person person) {
        return PersonResponseDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }

    public static PersonRelationCharacterDTO toPersonRelationCharacterDTO(Person person) {
        return PersonRelationCharacterDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }
}
