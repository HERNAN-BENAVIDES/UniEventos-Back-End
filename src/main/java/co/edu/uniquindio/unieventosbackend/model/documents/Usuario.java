package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCuenta;
import co.edu.uniquindio.unieventosbackend.model.enums.Rol;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("ALL")
public class Usuario {
    private String correo;
    private String contrasenia;
    private Rol rol;
    private EstadoCuenta estadoCuenta;

    @Builder
    public Usuario(String correo, String contrasenia, Rol rol, EstadoCuenta estadoCuenta) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.estadoCuenta = estadoCuenta;
    }
}
