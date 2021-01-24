package br.com.tormenta.interfaces.rest;

import br.com.tormenta.interfaces.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO) {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

}
