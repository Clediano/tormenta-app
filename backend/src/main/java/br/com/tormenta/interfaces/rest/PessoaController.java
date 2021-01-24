package br.com.tormenta.interfaces.rest;

import br.com.tormenta.domain.model.Pessoa;
import br.com.tormenta.domain.service.PessoaService;
import br.com.tormenta.interfaces.dto.PessoaDTO;
import br.com.tormenta.interfaces.dto.UuidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPessoa(@PathVariable("id") UUID pessoaId) {
        Pessoa pessoa = pessoaService.buscar(pessoaId);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> inserirPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.salvar(pessoaDTO.transformaParaPessoa());
        return new ResponseEntity<>(new UuidDTO(pessoa.getId()), HttpStatus.CREATED);
    }
}
