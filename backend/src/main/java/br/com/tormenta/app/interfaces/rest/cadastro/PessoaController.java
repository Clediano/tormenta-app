package br.com.tormenta.app.interfaces.rest.cadastro;

import br.com.tormenta.app.domain.model.Pessoa;
import br.com.tormenta.app.domain.service.PessoaService;
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
        Pessoa pessoa = pessoaService.buscar(pessoaId);
        return new ResponseEntity<>(PessoaMapper.INSTANCE.toPessoaDTO(pessoa), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> inserirPessoa(@RequestBody @Valid Pessoa pessoaReq) {
        Pessoa pessoa = pessoaService.salvar(pessoaReq);
        return new ResponseEntity<>(new UuidDTO(pessoa.getId()), HttpStatus.CREATED);
    }
}
