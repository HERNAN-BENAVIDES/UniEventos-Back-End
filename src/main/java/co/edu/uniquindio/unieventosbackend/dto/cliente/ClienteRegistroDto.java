package co.edu.uniquindio.unieventosbackend.dto.cliente;

import co.edu.uniquindio.unieventosbackend.dto.usuario.UsuarioRegistroDto;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public record ClienteRegistroDto(
        @NotBlank @Length(min = 10, max = 10)
        String cedula,
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank @Length(min = 10, max = 10)
        String telefono,
        UsuarioRegistroDto usuario
) {
}
