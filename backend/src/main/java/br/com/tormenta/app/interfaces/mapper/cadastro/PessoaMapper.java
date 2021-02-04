package br.com.tormenta.app.interfaces.mapper.cadastro;

import br.com.tormenta.app.domain.model.Pessoa;
import br.com.tormenta.app.interfaces.dto.cadastro.PessoaRequestDTO;
import br.com.tormenta.app.interfaces.dto.cadastro.PessoaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toPessoa(PessoaRequestDTO pessoa);

    PessoaResponseDTO toPessoaDTO(Pessoa pessoa);
}
