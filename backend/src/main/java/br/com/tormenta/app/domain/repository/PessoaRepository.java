package br.com.tormenta.app.domain.repository;

import br.com.tormenta.app.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    List<Pessoa> findByEmail(String email);
}