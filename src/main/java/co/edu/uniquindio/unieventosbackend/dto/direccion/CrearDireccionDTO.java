package co.edu.uniquindio.unieventosbackend.dto.direccion;

public record CrearDireccionDTO(
        String departamento,
        String ciudad,
        String barrio,
        String calle,
        String numResidencia
) {
}
