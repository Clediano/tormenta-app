package br.com.tormenta.app.interfaces.mapper.cadastro;

import br.com.tormenta.app.domain.model.Personagem;
import br.com.tormenta.app.interfaces.dto.cadastro.PersonagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonagemMapper {

    PersonagemMapper INSTANCE = Mappers.getMapper(PersonagemMapper.class);

    Personagem toPersonagem(PersonagemDTO personagemDTO);

    PersonagemDTO toPersonagemDTO(Personagem personagem);
}
