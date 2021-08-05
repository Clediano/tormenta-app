package br.com.tormenta.app.domain.service;

import br.com.tormenta.app.domain.model.Character;
import br.com.tormenta.app.domain.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> findCharacters(UUID personId) {
        return characterRepository.findByPersonId(personId);
    }
}
