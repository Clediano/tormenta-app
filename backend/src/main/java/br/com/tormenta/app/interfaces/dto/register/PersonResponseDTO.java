package br.com.tormenta.app.interfaces.dto.register;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PersonResponseDTO {

    private UUID id;

    private String name;

    private String email;
}
