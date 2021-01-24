package br.com.tormenta.security.domain.service;

import br.com.tormenta.app.domain.model.Pessoa;
import br.com.tormenta.app.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Pessoa> pessoa = pessoaRepository.findByEmail(username);
        if (!pessoa.isEmpty()) {
            return new User(pessoa.get(0).getEmail(), pessoa.get(0).getSenha(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
        }
    }
}