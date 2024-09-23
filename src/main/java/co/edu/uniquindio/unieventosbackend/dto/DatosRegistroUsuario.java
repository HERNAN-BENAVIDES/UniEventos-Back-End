package co.edu.uniquindio.unieventosbackend.dto;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCuenta;
import co.edu.uniquindio.unieventosbackend.model.enums.Rol;

public record DatosRegistroUsuario(
        String correoElectronico,
        String contrasenia,
        Rol rol,
        EstadoCuenta estadoCuenta
) {
}
