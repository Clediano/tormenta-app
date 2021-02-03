package br.com.tormenta.app.interfaces.rest;

import br.com.tormenta.app.domain.model.Pessoa;
import br.com.tormenta.app.domain.service.PessoaService;
import br.com.tormenta.app.interfaces.dto.cadastro.PessoaDTO;
import br.com.tormenta.app.interfaces.dto.common.UuidDTO;
import br.com.tormenta.app.interfaces.mapper.cadastro.PessoaMapper;
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
        PessoaDTO pessoaDTO = PessoaMapper.INSTANCE.toPessoaDTO(pessoaService.buscar(pessoaId));
        return new ResponseEntity<>(PessoaMapper.INSTANCE.toPessoa(pessoaDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> inserirPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.salvar(PessoaMapper.INSTANCE.toPessoa(pessoaDTO));
        return new ResponseEntity<>(new UuidDTO(pessoa.getId()), HttpStatus.CREATED);
    }
}
