package br.com.tormenta.app.interfaces.dto.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRelationCharacterDTO {
    @NotNull
    private UUID id;

    private String name;

    private String email;
}
