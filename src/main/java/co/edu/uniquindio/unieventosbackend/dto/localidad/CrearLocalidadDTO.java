package co.edu.uniquindio.unieventosbackend.dto.localidad;

public record CrearLocalidadDTO(
        String nombre,
        String descripcion,
        Integer capacidadMaxima
) {
}
