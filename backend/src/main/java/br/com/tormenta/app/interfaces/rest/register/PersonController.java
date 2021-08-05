package br.com.tormenta.app.interfaces.rest.register;

import br.com.tormenta.app.domain.model.Person;
import br.com.tormenta.app.domain.service.PersonService;
import br.com.tormenta.app.interfaces.dto.common.UuidDTO;
import br.com.tormenta.app.interfaces.dto.register.PersonRequestDTO;
import br.com.tormenta.app.interfaces.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findPerson(@PathVariable("id") UUID pessoaId) {
        Person person = personService.buscar(pessoaId);
        return new ResponseEntity<>(PersonMapper.toPersonResponseDTO(person), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertPerson(@RequestBody @Valid PersonRequestDTO personReq) {
        Person person = personService.save(PersonMapper.toPerson(personReq));
        return new ResponseEntity<>(new UuidDTO(person.getId()), HttpStatus.CREATED);
    }
}
