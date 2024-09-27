package co.edu.uniquindio.unieventosbackend.dto.evento;

import co.edu.uniquindio.unieventosbackend.dto.direccion.CrearDireccionDTO;
import co.edu.uniquindio.unieventosbackend.dto.localidad.CrearLocalidadDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public record CrearEventoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotBlank
        String tipoEvento,
        @NotBlank
        String poster,
        @NotBlank
        String imgLocalidades,
        Date fecha,
        CrearDireccionDTO direccion,
        List<CrearLocalidadDTO>listaLocalidades
) {
}
