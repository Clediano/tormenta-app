package br.com.tormenta.app.interfaces.rest.security;

import br.com.tormenta.app.domain.model.Person;
import br.com.tormenta.app.domain.repository.PersonRepository;
import br.com.tormenta.app.configuration.JwtTokenUtil;
import br.com.tormenta.app.domain.model.JwtRequest;
import br.com.tormenta.app.domain.model.JwtResponse;
import br.com.tormenta.app.domain.service.JwtUserDetailsService;
import br.com.tormenta.app.exception.business.security.AuthenticateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authenticate")
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final Person person = personRepository.findByEmail(authenticationRequest.getEmail()).get(0);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(person.getId(), person.getName(), person.getEmail(), token));
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticateException("Usuário está inativo");
        } catch (BadCredentialsException e) {
            throw new AuthenticateException("Usuário ou senha inválido");
        }
    }

}
