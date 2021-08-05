package br.com.tormenta.app.domain.service;

import br.com.tormenta.app.domain.model.Person;
import br.com.tormenta.app.domain.repository.PersonRepository;
import br.com.tormenta.app.exception.business.PersonException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Person save(Person person) {
        this.validate(person);
        String encodedPassword = bCryptPasswordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        return personRepository.save(person);
    }

    public Person buscar(UUID idPessoa) {
        Optional<Person> pessoa = personRepository.findById(idPessoa);
        if (!pessoa.isPresent()) {
            throw new PersonException("Nenhuma pessoa foi encontrada");
        }
        return pessoa.get();
    }

    private void validate(Person person) {
        List<Person> response = personRepository.findByEmail(person.getEmail());
        if (!response.isEmpty()) {
            throw new PersonException("Já existe uma pessoa com este e-mail cadastrada no sistema");
        }
    }
}
