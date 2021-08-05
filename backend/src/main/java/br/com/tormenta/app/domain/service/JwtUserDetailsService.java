package br.com.tormenta.app.domain.service;

import br.com.tormenta.app.domain.model.Person;
import br.com.tormenta.app.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Person> person = personRepository.findByEmail(username);
        if (!person.isEmpty()) {
            return new User(person.get(0).getEmail(), person.get(0).getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
        }
    }
}