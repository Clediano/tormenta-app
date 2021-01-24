package br.com.tormenta.app.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UuidDTO {
    private UUID id;

    public UuidDTO(UUID id) {
        this.id = id;
    }
}
