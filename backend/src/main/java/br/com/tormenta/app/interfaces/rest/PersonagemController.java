package br.com.tormenta.app.interfaces.rest;

import br.com.tormenta.app.domain.model.Personagem;
import br.com.tormenta.app.domain.service.PersonagemService;
import br.com.tormenta.app.interfaces.dto.cadastro.PersonagemDTO;
import br.com.tormenta.app.interfaces.dto.common.UuidDTO;
import br.com.tormenta.app.interfaces.mapper.cadastro.PersonagemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;


    @GetMapping("/pessoa/{id}")
    public ResponseEntity<?> buscarPessoa(@PathVariable("id") UUID pessoaId) {
        List<Personagem> personagens = personagemService.buscarPeronagens(pessoaId);
        return new ResponseEntity<>(PersonagemMapper.INSTANCE.toPersonagemDTO(personagens.get(0)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> inserirPersonagem(@RequestBody @Valid PersonagemDTO personagemDTO) {
        Personagem personagem = personagemService.salvar(PersonagemMapper.INSTANCE.toPersonagem(personagemDTO));
        return new ResponseEntity<>(new UuidDTO(personagem.getId()), HttpStatus.CREATED);
    }
}
