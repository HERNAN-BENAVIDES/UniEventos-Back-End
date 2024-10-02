package co.edu.uniquindio.unieventosbackend.dto.jwt;

import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;

public record JWTDto(
        String token,
        Cliente cliente
) {
}
