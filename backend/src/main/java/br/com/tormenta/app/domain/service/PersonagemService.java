package br.com.tormenta.app.domain.service;

import br.com.tormenta.app.domain.model.Personagem;
import br.com.tormenta.app.domain.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem salvar(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> buscarPeronagens(UUID idPessoa) {
        return personagemRepository.findByPessoaId(idPessoa);
    }
}
