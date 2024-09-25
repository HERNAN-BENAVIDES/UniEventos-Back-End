package co.edu.uniquindio.unieventosbackend.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UsuarioRegistroDto(
        @NotBlank
        String username,
        @NotBlank @Length(min = 8)
        String password
) {
}
