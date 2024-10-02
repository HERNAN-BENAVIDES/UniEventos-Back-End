package co.edu.uniquindio.unieventosbackend.dto.jwt;


import co.edu.uniquindio.unieventosbackend.model.documents.interfaces.Persona;

public record JWTDto(
        String token,
        Persona persona
) {
}
