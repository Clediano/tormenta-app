package br.com.tormenta.app.interfaces.mapper.cadastro;

import br.com.tormenta.app.domain.model.Pessoa;
import br.com.tormenta.app.interfaces.dto.cadastro.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(target = "senha", ignore = true)
    Pessoa toPessoa(PessoaDTO pessoa);

    PessoaDTO toPessoaDTO(Pessoa product);
}
