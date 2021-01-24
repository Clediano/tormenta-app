package br.com.tormenta.domain.service;

import br.com.tormenta.domain.model.Pessoa;
import br.com.tormenta.domain.repository.PessoaRepository;
import br.com.tormenta.infrastructure.exception.business.PessoaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Pessoa salvar(Pessoa pessoa) {
        this.validar(pessoa);
        String encodedPassword = bCryptPasswordEncoder.encode(pessoa.getSenha());
        pessoa.setSenha(encodedPassword);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscar(UUID idPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        if (!pessoa.isPresent()) {
            throw new PessoaException("Nenhuma pessoa foi encontrada");
        }
        return pessoa.get();
    }

    private void validar(Pessoa pessoa) {
        List<Pessoa> response = pessoaRepository.findByEmail(pessoa.getEmail());
        if (!response.isEmpty()) {
            throw new PessoaException("Já existe uma pessoa com este e-mail cadastrada no sistema");
        }
    }
}