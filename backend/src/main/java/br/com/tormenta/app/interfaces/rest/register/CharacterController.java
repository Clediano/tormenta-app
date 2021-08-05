package br.com.tormenta.app.interfaces.rest.register;

import br.com.tormenta.app.domain.model.Character;
import br.com.tormenta.app.domain.service.CharacterService;
import br.com.tormenta.app.interfaces.dto.register.CharacterDTO;
import br.com.tormenta.app.interfaces.dto.common.UuidDTO;
import br.com.tormenta.app.interfaces.mappers.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("/people/{id}")
    public ResponseEntity<?> findPerson(@PathVariable("id") UUID personId) {
        List<Character> characters = characterService.findCharacters(personId);
        if(characters.isEmpty()) {
            return new ResponseEntity<>(characters, HttpStatus.OK);
        }
        return new ResponseEntity<>(characters.stream().map(CharacterMapper::toCharacterDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        Character character = characterService.save(CharacterMapper.toCharacter(characterDTO));
        return new ResponseEntity<>(new UuidDTO(character.getId()), HttpStatus.CREATED);
    }
}
